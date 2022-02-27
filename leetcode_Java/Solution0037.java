// 解数独


/*
回溯：
1、本题中棋盘的每一个位置都要放一个数字，并检查数字是否合法，解数独的树形结构要比N皇后更宽更深。
2、为什么递归函数的返回值需要是bool类型？
  因为解数独找到一个符合的条件（就在树的叶子节点上）立刻就返回，相当于找从根节点到叶子节点一条唯一路径，所以需要使用bool返回值
3、本题在原二维数组上操作，因此不需要增加额外的数据结构
4、本题递归不用终止条件，解数独是要遍历整个树形结构寻找可能的叶子节点就立刻返回
5、本题需要 二维递归，也就是两个for循环嵌套着递归
  一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！
 */
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(row, col, val, board)) {
                        board[row][col] = val;
                        if (backtrack(board)) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置
        return true;
    }

    private boolean isValid(int row, int col, char val, char[][] board) {
        // 判断同一行是否有重复的数
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 判断同一列是否有重复的数
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 判断九宫格是否有重复的数
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}