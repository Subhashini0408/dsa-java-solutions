/*
Problem: Set Matrix Zeroes

Approach:
Use the first row and first column of the matrix as markers
instead of using extra arrays.

1. Check whether the first row or first column initially contains zeroes.
2. Traverse the inner matrix:
   - If a zero is found, mark its corresponding first row
     and first column cell as zero.
3. Traverse the inner matrix again:
   - If either row marker or column marker is zero,
     set the current element to zero.
4. Finally, update the first row and first column
   based on the stored boolean flags.

Time Complexity: O(m × n)
Space Complexity: O(1)
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        
        //optimized approach
        int rows = matrix.length;
        int column = matrix[0].length;

        boolean rowzero = false;
        boolean colzero = false;

        //search if zero is present in first row or first column, if zeros present , then mark it as true
        for(int j = 0 ; j < column ; j++)
        {
            if(matrix[0][j] == 0)
            {
                rowzero = true;
            }
        }

        for(int i = 0 ; i < rows ; i++)
        {
            if(matrix[i][0] == 0)
            {
                colzero = true;
            }
        }

        //traverse elements in array for zeros,if it contains zeros then mark its first row and first
        //column as zero (heads as zeros)
        for(int i = 1 ; i < rows ; i++)
        {
            for(int j = 1 ; j < column ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //then find the non zero elements in inner matrix, if one of the heads is zero , then mark this 
        //element as zero
        for(int i = 1 ; i < rows ; i++)
        {
            for(int j = 1 ; j < column ; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        //last step : if rowzero or colzero is true , then mark the entire rows or cols as zeros
        if(rowzero == true)
        {
            for(int j = 0 ; j < column ; j++)
            {
                matrix[0][j] = 0;
            }
        }
        if(colzero == true)
        {
            for(int i = 0 ; i < rows ; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
