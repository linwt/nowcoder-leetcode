// 739. 每日温度


/*
暴力：两层for循环遍历数组，查找每个元素右边第一个比它大的元素，计算索引差得到天数i，即为日期left在第i天之后才会有更高的温度
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int left = 0; left < n - 1; left++) {
            for (int right = left + 1; right < n; right++) {
                if (temperatures[left] < temperatures[right]) {
                    res[left] = right - left;
                    break;
                }
            }
        }
        return res;
    }
}


/*
单调递减栈：
1、查找每个元素右边第一个比它大的元素，可以利用单调递减栈的特性
2、利用栈存放索引，这样既可以通过索引差获取天数，也可以通过索引从数组获取温度值
3、遍历数组
  1）栈为空 或 当前温度不大于栈顶温度，则当前索引入栈
  2）栈不为空 且 当前温度大于栈顶温度，则弹出栈顶索引作为日期左边界，当前索引作为日期右边界，计算日期相差天数i，得到出栈索引日期在第i天之后才会有更高的温度。
    循环弹出处理，当前温度不大于新栈顶温度，最后当前索引入栈，保证了栈内元素单调递减
4、剩余栈不为空，说明部分日期后没有更高的温度，天数统一为0，由于数组初始化默认值为0，所以不用处理
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int right = 0; right < n; right++) {
            while (!stack.isEmpty() && temperatures[right] > temperatures[stack.peek()]) {
                int left = stack.pop();
                res[left] = right - left;
            }
            stack.push(right);
        }
        return res;
    }
}