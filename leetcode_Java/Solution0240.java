// 240. 搜索二维矩阵 II


/*
二分查找：
1、从左下角开始，在有效边界范围内，元素小于目标值则右移，元素大于目标值则上移
2、如果找到了目标值则返回true，遍历结束后没找到目标值则返回false
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = m - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}