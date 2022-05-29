// 59. 滑动窗口的最大值
// 同力扣“239. 滑动窗口最大值”

/*
单调递减队列，左头右尾
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length) {
            return list;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 去掉比当前值小的值
            while (!queue.isEmpty() && num[i] > num[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 判断队首元素是否不在窗口内
            if (queue.peekFirst() == i - size) {
                queue.pollFirst();
            }
            // 添加当前窗口的最大值
            if (i >= size - 1) {
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }
}
