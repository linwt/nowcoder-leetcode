// N 皇后


/*
回溯

思路：
1、皇后有效位置：不能同行、不能同列、不能同斜线
2、检查皇后位置是否有效，即检查同列、45°角、135°角是否有皇后。当前行只有一个皇后，不用检查；下半部分的行未遍历，不用检查
3、棋盘的宽度就是for循环的长度，棋盘的高度就是递归的深度

步骤：
1、定义全局结果列表res，定义二维字符数组chessBoard表示棋盘
2、初始化棋盘，调用递归函数，处理得到结果，返回结果
3、定义递归函数
   1）终止条件：棋盘的行遍历完，将 二维字符数组 转 字符串列表，存入res
   2）单层递归逻辑：遍历该行的每一列，选择一个位置，判断能否放皇后，能则进入下一行递归处理，回溯撤销皇后，继续判断下一列
 */
class Solution {
    private List<List<String>> res = new ArrayList<>();
    private char[][] chessBoard;

    public List<List<String>> solveNQueens(int n) {
        chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            res.add(arrayToList());
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col)) {
                chessBoard[row][col] = 'Q';
                backtrack(n, row + 1);
                chessBoard[row][col] = '.';
            }
        }
    }

    // 二维字符数组 转 字符串列表
    private List arrayToList() {
        List<String> list = new ArrayList<>();
        for (char[] c : chessBoard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    // 检查是否有皇后
    private boolean isValid(int n, int row, int col) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45°角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135°角
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}


/*
回溯，同上，检查是否有皇后思路不同
思路：遍历每一行。因为每一行n、每一列col、每一对角线dg、每一反对角线bdg，最多只能存在一个皇后
其中对角线bg相当于一个跨坐标轴一三象限的y=x+b函数，反对角线bdg相当于一个跨坐标轴二四象限的y=-x+b函数
两者截距b分别为y-x和y+x，由于y-x可能为负数，又因为数组下标不能为负数，故需要加上一个偏移量n
所以对应到两对角线的代码分别为：n - u + i和u + i
 */
class Solution {
    private List<List<String>> res = new ArrayList<>();
    char[][] chessBoard;
    boolean col[], dg[], bdg[];

    public List<List<String>> solveNQueens(int n) {
        chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        col = new boolean[2 * n];
        dg = new boolean[2 * n];
        bdg = new boolean[2 * n];
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            res.add(arrayToList());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[n - row + i] && !bdg[row + i]) {
                chessBoard[row][i] = 'Q';
                col[i] = dg[n - row + i] = bdg[row + i] = true;
                backtrack(n, row + 1);
                chessBoard[row][i] = '.';
                col[i] = dg[n - row + i] = bdg[row + i] = false;
            }
        }
    }

    private List arrayToList() {
        List<String> list = new ArrayList<>();
        for (char[] c : chessBoard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}