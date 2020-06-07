import matplotlib.pyplot as plt
from os import listdir
from os.path import isfile, isdir, join

# load the files

def load_file(filename):
    with open(filename, "r") as f:
        text = f.read()
        text = text.replace("-","")
        splitted = text.split("\n")
        return splitted


def collect_all_files_rec(directory):
    filenames = listdir(directory)
    files = []
    for name in filenames:
        joined_filename = join(directory,name)
        if isfile(joined_filename):
            files.append(load_file(joined_filename))
        if isdir(joined_filename):
            files = files + collect_all_files_rec(joined_filename)
    return files

def plot_all_files(content_groups):
    for group in content_groups:
        plt.xlabel("KB")
        plt.ylabel("Time in ms")
        parsed_grammars = []
        for content in group:
            header,(start,stop),timings = content
            x = range(int(start),int(stop)+1)
            parser_name, parsed_grammar_ = header
            parsed_grammars.append(parsed_grammar_)
            timings_numbers = []
            print(timings)
            for timing in timings:
                if timing == "": continue
                timings_numbers.append(float(timing))
            
            plt.plot(x,timings_numbers,label = parser_name)
        assert(len(set(parsed_grammars)) == 1)
        plt.title(parsed_grammars[0])
        plt.legend()
        plt.show()


def create_file_groups(file_contents):
    file_groups = dict()
    out_groups = []
    for content in file_contents:
        parser_name, parsed_grammar = content[0].split(",")
        if(not parsed_grammar in file_groups):
            file_groups[parsed_grammar] = []
        file_groups[parsed_grammar].append([(parser_name,parsed_grammar),content[1].split(","), content[2].split(",")])
    
    for group in file_groups.values():
        out_groups.append(group)
    
    return out_groups

def main():
    # access the timings directory n shit
    files = collect_all_files_rec("../timings")
    content_groups = create_file_groups(files)
    plot_all_files(content_groups)
    print("done")

if __name__ == '__main__':
    main()
