// 130. 被围绕的区域


/*
深度优先搜索：
1、遍历四条边界，将边界的 O 换成 Y，剩下的 O 就是被 X 围绕的区域
2、两层for循环遍历二维数组每个位置，当碰到 O 时，通过深度优先搜索往上下左右四个方向扩散，将 O 换成 X；当碰到 Y 时，将 Y 恢复成 O
 */
class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for (int row = 0; row < n; row++) {
            dfs(board, row, 0);
            dfs(board, row, m - 1);
        }
        for (int col = 0; col < m; col++) {
            dfs(board, 0, col);
            dfs(board, n - 1, col);
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'Y') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int n = board.length, m = board[0].length;
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'Y';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}