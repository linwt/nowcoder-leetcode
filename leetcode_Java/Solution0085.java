// 85. 最大矩形


/*
暴力破解/动态规划：
1、思路：遍历每个点，求以这个点为矩形右下角的所有矩形面积，比较并记录最大面积
2、二维数组width用于记录每行上每个点结尾的连续 1 的个数，即每行上每个点结尾时的宽度。width可以理解为dp数组，保存状态
3、从左到右遍历，计算并记录每行上每个点结尾时的宽度
4、计算面积
  1）首先求出高度是 1 的矩形面积，即高度只有一行，宽度是该点记录的宽度
  2）然后向上扩展一行，高度增加1，选出width当前列最小的数字，即多行的宽度选择最小的宽度为有效宽度，作为矩形的宽度，求出面积
  3）然后继续向上扩展，重复步骤 2，求出所有可能的高度时的面积
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxArea = 0;
        int[][] width = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    width[row][col] = col == 0 ? 1 : width[row][col - 1] + 1;
                }
                int midWidth = width[row][col];
                for (int rowUp = row; rowUp >= 0; rowUp--) {
                    int height = row - rowUp + 1;
                    midWidth = Math.min(midWidth, width[rowUp][col]);
                    maxArea = Math.max(maxArea, midWidth * height);
                }
            }
        }
        return maxArea;
    }
}


/*
暴力破解：
1、遍历每一行的时候，从上往下计算每一列连续1的个数作为矩形高度，得到高度矩阵
2、遍历高度矩阵，以当前点的值作为矩形高度，向左右两边扩展高度大于等于当前高度的边界得到宽度，从而计算该点的最大面积
3、比较并记录矩阵所有点的最大面积，得出整个矩阵的最大面积
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] heights = new int[m][n];
        int maxArea = 0;
        for (int col = 0; col < n; col++) {
            heights[0][col] = matrix[0][col] == '1' ? 1 : 0;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    heights[row][col] = heights[row - 1][col] + 1;
                }
            }
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (heights[row][col] == 0 || heights[row][col] * n <= maxArea) {
                    continue;
                }
                int width = 1;
                for (int k = col - 1; k >= 0; k--) {
                    if (heights[row][k] < heights[row][col]) {
                        break;
                    }
                    width++;
                }
                for (int k = col + 1; k < n; k++) {
                    if (heights[row][k] < heights[row][col]) {
                        break;
                    }
                    width++;
                }
                maxArea = Math.max(maxArea, width * heights[row][col]);
            }
        }
        return maxArea;
    }
}


/*
单调递增栈：
1、遍历每一行的时候，从上往下计算每一列连续1的个数作为矩形高度，得到高度数组
2、直接利用“84. 柱状图中最大的矩形”的解法，传入高度数组，得到最大矩形面积
3、在所有行的矩形面积结果中，记录最大面积
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int right = 0; right < n + 2; right++) {
            while (!stack.isEmpty() && newHeights[right] < newHeights[stack.peek()]) {
                int cur = stack.pop();
                int left = stack.peek();
                int area = (right - left - 1) * newHeights[cur];
                res = Math.max(res, area);
            }
            stack.push(right);
        }
        return res;
    }
}