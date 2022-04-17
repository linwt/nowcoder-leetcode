// 59. 螺旋矩阵 II


/*
思路同“54.螺旋矩阵”
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            if (left > right) break;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            if (top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
            if (left > right) break;
        }
        return matrix;
    }
}