// 二维区域和检索 - 矩阵不可变


/*
一维前缀和：
1、初始化时对矩阵的每一行计算前缀和，检索时对二维区域中的每一行计算子数组和，然后对每一行的子数组和计算总和。
2、preSum[n][m] 表示矩阵matrix 左上角为(n, 0) 右下角为 (n, m-1) 的子矩形范围元素和
3、preSum 初始化时比 matrix 多了一列，用于初始化前缀和矩阵首列为0
4、检索的时间复杂度是 O(m)
 */
class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        preSum = new int[n][m + 1];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                preSum[row][col + 1] = preSum[row][col] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += preSum[i][col2 + 1] - preSum[i][col1];
        }
        return res;
    }
}



/*
二维前缀和：
1、preSum[n][m] 表示矩阵matrix 左上角为(0, 0) 右下角为 (n-1, m-1) 的子矩形范围元素和
2、preSum 初始化时比 matrix 多了一行一列，用于初始化前缀和矩阵首行首列为0
3、前缀和矩阵元素填充、计算子矩形元素和，都是通过其他子矩形的面积加减得到
4、检索的时间复杂度是 O(1)
 */
class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        preSum = new int[n + 1][m + 1];
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                preSum[row][col] = preSum[row - 1][col] + preSum[row][col - 1] - preSum[row - 1][col -1] + matrix[row - 1][col - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */