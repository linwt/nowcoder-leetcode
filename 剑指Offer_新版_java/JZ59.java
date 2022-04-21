// 59. 滑动窗口的最大值


public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length) {
            return list;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 去掉比当前值小的值
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 判断队首元素是否过期
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
