// 84. 柱状图中最大的矩形


/*
暴力：
1、数组扩容，首尾添加哨兵0元素，作为最低点，方便作为任意高度的左右边界
2、遍历柱子高度，对于每一个柱子高度分别向两边扩散，求出当前高度为矩形的最大宽度
3、最大宽度的 左边界是当前柱子向左遍历第一个低于当前柱子高度的位置，右边界是当前柱子向右遍历第一个低于当前柱子高度的位置，左右边界的距离就是最大宽度
4、当前柱子最大面积 = 最大宽度 * 当前柱子高度，比较并保存最大面积

高度： 0   2   1   5   6   2   3   0
索引： 0   1   2   3   4   5   6   7
              ↑   ↑       ↑
            left  i     right
(right - left - 1) * newHeights[i] = (5-2-1)*5 = 10
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newHeights[i + 1] = heights[i];
        }
        for (int i = 1; i < n + 1; i++) {
            int left = i - 1;
            while (left > 0 && newHeights[i] <= newHeights[left]) {
                left--;
            }
            int right = i + 1;
            while (right < n + 2 && newHeights[i] <= newHeights[right]) {
                right++;
            }
            int area = (right - left - 1) * newHeights[i];
            res = Math.max(res, area);
        }
        return res;
    }
}


/*
单调栈
1、单调栈分为单调递增栈和单调递减栈
  1)单调递增栈，即栈内元素保持单调递增的栈
  2)单调递减栈，即栈内元素保持单调递减的栈
2、操作规则（下面都以单调递增栈为例）
  1)如果新元素比栈顶元素大，就入栈
  2)如果新元素比栈顶元素小，那就一直把栈顶元素弹出来，直到栈顶元素比新元素小，然后新元素入栈
3、规则效果（举例：栈[1, 5, 6]，新元素2）
  1)栈内的元素是递增的
  2)当元素出栈时，这个新元素是出栈元素向右找第一个比它小的元素（2是6右边第一个比它小的元素）
  3)当元素出栈后，新栈顶元素是出栈元素向左找第一个比它小的元素（5是6左边第一个比它小的元素）
4、使用单调栈的场景
  1)需要查找数组每个元素左或右边第一个比它大或小的元素和索引时，可以用单调栈
  2)利用栈存放索引，这样既可以通过索引获取索引差值，也可以通过索引从数组获取元素值
  3)查找第一个比它大的元素时，用单调递减栈。因为新元素比它小时会入栈，形成单调递减栈，比它大时会出栈。
  4)查找第一个比它小的元素时，用单调递增栈。因为新元素比它大时会入栈，形成单调递增栈，比它小时会出栈。
 */


/*
单调递增栈：
1、暴力解法每次都要重新求当前柱子的左右边界，时间复杂度O(n²)，空间复杂度O(1)
  核心思路是要找到当前柱子的左右边界 左边第一个高度小于它的位置 和 右边第一个高度小于它的位置，因此可以利用单调递增栈的特性，时间复杂度O(1)，空间复杂度O(n)
2、数组扩容，首尾添加哨兵0元素，作为最低点，方便作为任意高度的左右边界
3、利用栈存放索引，这样既可以通过索引差获取宽度，也可以通过索引从数组获取高度
3、遍历数组
  1）栈为空 或 当前高度大于栈顶高度 则当前索引入栈
  2）栈不为空 且 当前高度小于栈顶高度，则弹出栈顶高度作为矩形高度，新栈顶索引是左边界，当前索引是右边界，计算面积并保存最大面积。
     循环弹出处理，直到新栈顶高度比当前高度小，最后当前索引入栈，保证了栈内元素单调递增
4、单调递增栈使得每一个出栈的柱子高度，都能通过 新栈顶索引 和 当前索引 快速获取左右边界，每一个柱子高度都会入栈，从而快速计算了每个柱子高度为矩形的最大面积
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
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