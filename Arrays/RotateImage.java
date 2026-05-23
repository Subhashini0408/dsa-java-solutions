/*
Problem: Rotate Image
Approach:
1. Transpose matrix
2. Reverse each row

Time Complexity: O(n^2)
Space Complexity: O(1)
*/
class Solution {
    public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int n = matrix.length;

        //transpose + reverse logic , swap all the elements to other side until diagonal
        for(int i = 0 ; i < rows ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each rows of the matrix
        for(int i = 0 ; i < rows ; i++)
        {
             for(int j = 0 ; j < n / 2 ; j++)
             {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
             }
        }
    }
}
