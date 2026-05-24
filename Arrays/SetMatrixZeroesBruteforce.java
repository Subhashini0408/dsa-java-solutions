/*
Problem: Set Matrix Zeroes

Approach:
Use two boolean arrays to track which rows and columns
contain zeroes. Traverse the matrix and mark the corresponding
row and column whenever a zero is found.
In the second traversal, set matrix elements to zero if their
row or column is marked.

Time Complexity: O(m × n)
Space Complexity: O(m + n)
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] rowzero = new boolean[matrix.length];
        boolean[] colzero = new boolean[matrix[0].length];

        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rowzero[i] = true;
                    colzero[j] = true;
                }
            }
        }

       for(int i = 0 ; i < rows ; i++)
       {
          for(int j = 0 ; j < cols ; j++)
          {
             if(rowzero[i] || colzero[j])
             {
                 matrix[i][j] = 0;
             }
          }
       }
    }
}
