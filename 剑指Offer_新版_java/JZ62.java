// 62. 孩子们的游戏(圆圈中最后剩下的数)


public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        // 编号，报数，出列人数
        int number = -1, step = 0, count = n;
        while (count > 0) {
            number++;
            // 模拟环，编号重新开始
            if (number >= n) {
                number = 0;
            }
            // 跳过已出列
            if (array[number] == -1) {
                continue;
            }
            step++;
            if (step == m) {
                // 出列
                array[number] = -1;
                // 重新报数
                step = 0;
                // 出列人数减1
                count--;
            }
        }
        return number;
    }
}
