//  79. 单词搜索


/*
深度优先搜索，回溯：
1、把递归方法用到的公共变量作为成员变量，避免入参冗杂，入参只保留方法独用的局部变量
2、遍历字符网格，以每个字符作为单词搜索的起点，搜索成功返回true，遍历完后仍未搜索成功则返回false
3、定义递归函数：
  1）终止条件：
    ① 索引等于单词长度，表示搜索成功结束，返回true
    ② 网格越界、网格字符已访问、网格字符与单词字符不同，返回false
  2）递归回溯：
    ① 未达到终止条件前，需要继续搜索。先标记当前位置已访问，然后从上下左右四个方向继续搜索，获取搜索结果进行或运算，表示其中一个搜索成功即为成功
    ② 如果四个方向都搜索失败，需要重新标记当前位置未访问，不影响其他递归搜索，即回溯
    ③ 将搜索结果返回给上一层
 */
class Solution {
    private char[][] board;
    private String word;
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        this.visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (dfs(0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || word.charAt(index) != board[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean res = dfs(index + 1, row + 1, col)
                || dfs(index + 1, row - 1, col)
                || dfs(index + 1, row, col + 1)
                || dfs(index + 1, row, col - 1);
        if (!res) {
            visited[row][col] = false;
        }
        return res;
    }
}