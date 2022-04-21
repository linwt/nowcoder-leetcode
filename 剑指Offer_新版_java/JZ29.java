// 顺时针打印矩阵


/*
相似题“54.螺旋矩阵”、“59.螺旋矩阵II”

1、指针视角
         left       right
          ↓           ↓
   top →  1   2   3   4
          5   6   7   8
          9  10  11  12
bottom → 13  14  15  16

2、访问顺序：1 2 3 4   8 12 16   15 14 13   9 5   6 7   11   10

3、matrix[行][列]：明确行是谁，列是谁，谁变化
   顶行：matrix[top][left → right]    不变的是行，变化的是列，列左到右
   右列：matrix[top → bottom][right]  不变的是列，变化的是行，行上到下
   底行：matrix[bottom][right → left] 不变的是行，变化的是列，列右到左
   左列：matrix[bottom → top][left]   不变的是列，变化的是行，行下到上

4、此解法最容易理解，算法过程
  1）先初始化上下左右四个指针
  2）开始循环遍历，顺时针遍历一圈，每遍历完一行或一列，该行或该列指针向内移动一步，作为新的可遍历边界
  3）只要 上超过下 或 左超过右，说明已经全部遍历完了，可以结束循环了
 */
class Solution {
    public List<Integer> printMatrix(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int top = 0, bottom = row - 1, left = 0, right = col - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return res;
    }
}


public class Solution {
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