import TextGenerator as tg
import sys
import math


def size_to_index(size):
    return size-1

def incremental_text_gen(res, start, stop_after_kb): # 20 KB default 
    std_factor = 0.01
    is_size = 0 # In Kb
    must_size = start
    base_increase = 0.01
    margin = 0.1
    txt_cache = [None for _ in range(stop_after_kb)] # Prefill
    threshold = 100
    amount = 0

    while must_size <= stop_after_kb:
        iteration_result = [] # 0 <=> is_size >= must_size, 1 <=> is_size < must_size
        txt = ""
        while not math.isclose(is_size,must_size,abs_tol=margin):
            # If we have a number that is close to another requested size > must_size, don't throw the result away.
            for must_size_bigger in range(must_size+1,stop_after_kb+1):
                if math.isclose(is_size,must_size_bigger,abs_tol=margin):
                    if txt_cache[size_to_index(must_size_bigger)] == None:
                        txt_cache[size_to_index(must_size_bigger)] = txt # Cache it back
                        amount+=1
                        print(f"({amount}/{stop_after_kb}) Precomputed: ~size {must_size_bigger}KB, actual size {is_size}KB, standard decrease factor {std_factor}")

            if len(iteration_result) > threshold:
                # Adapt the std_factor
                perc_iterations_lesser = sum(iteration_result) / threshold # This is now the factor that is used to increase/decrease std_factor
                # perc_iteration_lesser < 0.5 => decrease, perc_iteration_lesser >= 0.5 => increase
                if perc_iterations_lesser < 0.5:
                    std_factor -= perc_iterations_lesser * base_increase
                else:
                    std_factor += perc_iterations_lesser * base_increase
                iteration_result = []


            txt = tg.start_textgen(res,std_factor)
            if txt == None: return []
            is_size = len(txt) / 1000.0
            #print("Gened size:", is_size)
            iteration_result.append(int(is_size<must_size))

        txt_cache[must_size-1] = txt
        amount+=1
        print(f"({amount}/{stop_after_kb}) Finished: ~size {must_size}KB, actual size {is_size}KB, standard decrease factor {std_factor}")
        # Increase must_size as long as we have already computed it:
        must_size += 1
        while must_size <= stop_after_kb and txt_cache[size_to_index(must_size)] != None:
            must_size += 1
    return txt_cache


def main():
    if len(sys.argv) < 3:
        sys.stderr.write(f"Error: not enough input from commandline")
        return -1
    elif len(sys.argv) > 3:
        sys.stderr.write(f"Error: too much input from commandline")
        return -1     
    
    filenameIn = sys.argv[1]
    filenameOutPrefix,suffix = tuple(sys.argv[2].split("."))

    res = tg.gen_parse_result(filenameIn)
    if res == []: return -1
    start = 1
    stop = 50
    txt_cache = incremental_text_gen(res,start, stop)

    for index, txt in enumerate(txt_cache):
        filenameOut = filenameOutPrefix + "_" + str(index+start) + "KB" + "." + suffix
        try:
            tg.write_file(txt,filenameOut)
        except OSError as e:
            sys.stderr.write(f"Error: An error occured when writing to a file: {e}")
            return -1
        #print(f"{len(txt)} bytes ({len(txt) / 1000}KB) have been written to", filenameOut)
    
    return 0

if __name__ == "__main__":
    main()


