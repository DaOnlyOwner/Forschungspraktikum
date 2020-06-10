#include <vector>
#include <algorithm>

typedef std::vector<std::vector<double>> matrix;

struct matrix
{
    std::vector<std::vector<double>> cols_rows;
    int max_col(int k) const
    {
        auto& kth_row = cols_rows[k] // Get the k-th row. 
        double val; int index;
        for(int i = k; i<cols_rows.size();i++)
        {
            double val_ = cols_rows[i][k]; // Get the ith row (iterating), and the kth column.
            if(val_ > val) 
            {
                val = val;
                index = i;
            }
        }
        return index;
    }

    void swap_rows(int i, int j)
    {
        // std::swap(cols_rows[i], cols_rows[j]);
        auto&& row_i = std::move(cols_rows[i]);
        cols_rows[i] = std::move(cols_rows[j]);
        cols_rows[j] = std::move(row_i);
    }

};

matrix gauss(const matrix& mat)
{
    matrix tmat = mat; // Copy 
    for(int k = 0; k<n-1; k++)
    {
        int idx = tmat.max_col(k);
        if(idx != k) tmat.swap_rows(k,idx);
       
        double d = tmat.cols_rows[k][k] / tmat.cols_rows[k+1][k];
        for (int i = k; i < tmat.cols_rows[0].size(); i++)
        {
            //auto& row_i = tmat.cols_rows[i];
            //row_i[i] = row_i[i] + (row_i[k] * d);
        }
    }
}