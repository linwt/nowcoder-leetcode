// 503. 下一个更大元素 II


/*
单调递减栈：
1、栈存放的是索引，因为需要索引映射到结果数组
2、由于是循环数组，故将两个数组拼接在一起模拟循环效果，相当于遍历两次数组，下标通过取余映射到数组索引
3、从左到右遍历数组，获取每个元素的下一个更大元素
  1）栈不为空 且 当前元素大于栈顶元素，则栈顶元素出栈，该栈顶元素的下一个更大元素就是当前元素，记录到结果数组中，循环处理，直到当前元素小于栈顶元素
  2）当前元素入栈
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}