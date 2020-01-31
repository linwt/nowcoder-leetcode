package offer;

import java.util.ArrayList;

// 顺时针打印矩阵
public class Test19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        // 计算循环次数
        int circle = (Math.min(row, col) - 1) / 2 + 1;
        for (int i = 0; i < circle; i++) {
            // 添加首行
            for (int j = i; j < col - i; j++)
                ans.add(matrix[i][j]);
            // 添加尾列
            for (int k = i + 1; k < row - i; k++)
                ans.add(matrix[k][col - i - 1]);
            // 添加尾行
            for (int m = col - i - 2; (m >= i) && (row - i - 1 != i); m--)
                ans.add(matrix[row - i - 1][m]);
            // 添加尾列
            for (int n = row - i - 2; (n > i) && (col - i - 1 != i); n--)
                ans.add(matrix[n][i]);
        }
        return ans;
    }
}