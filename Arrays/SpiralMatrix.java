Traverse a matrix in spiral order using boundary pointers (top, bottom, left, right).  
The solution iteratively moves in four directions: left → right, top → bottom, right → left, and bottom → top while shrinking the boundaries after each traversal.

- Time Complexity: O(m × n)
- Space Complexity: O(1) (excluding output list)
- Approach: Matrix Traversal / Simulation

  class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right)
        {
            // left -> right
            for(int j = left ; j <= right ; j++)
            {
                list.add(matrix[top][j]);
            }
            top++;

            // top -> bottom
            for(int i = top ; i <= bottom ; i++)
            {
                list.add(matrix[i][right]);
            }
            right--;

            // right -> left
            if(top <= bottom)
            {
                for(int j = right ; j >= left ; j--)
                {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // bottom -> top
            if(left <= right)
            {
                for(int i = bottom ; i >= top ; i--)
                {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}
