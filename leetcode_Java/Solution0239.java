// 239. 滑动窗口最大值


/*
剑指offer 64.滑动窗口的最大值
双端队列，单调递减队列：
1、根据数组长度和窗口大小，初始化结果数组长度
2、队列存放的是索引，既能通过索引判断是否在窗口内，也能通过索引获取元素值
3、遍历数组元素
  1）当队列不为空 且 当前元素大于等于队尾元素，则弹出队尾元素，循环处理
  2）当前元素加入队尾。此时队列是单调递减队列
  3）检查队首索引是否在窗口内，不在窗口内则弹出队首索引
  4）当前滑动窗口大小为k时，队首索引的元素是窗口内的最大值，加入结果数组
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peek() == i - k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }
}