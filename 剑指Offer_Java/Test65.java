package offer;

// 矩阵中的路径
public class Test65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, rows, cols, flag, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge(char[] matrix, int rows, int cols, boolean[] flag, char[] str, int i, int j, int k) {
        int index = i * cols + j;
        // 不符合的情况
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        // 全部匹配完
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;
        // 判断四个方向是否可行
        boolean res = judge(matrix, rows, cols, flag, str, i - 1, j, k + 1) ||      // 上
                judge(matrix, rows, cols, flag, str, i + 1, j, k + 1) ||            // 下
                judge(matrix, rows, cols, flag, str, i, j - 1, k + 1) ||            // 左
                judge(matrix, rows, cols, flag, str, i, j + 1, k + 1);              // 右
        if (res) {
            return true;
        }
        // 此路不通，回溯还原
        flag[index] = false;
        return false;
    }
}
