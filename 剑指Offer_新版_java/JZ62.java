// 62. 孩子们的游戏(圆圈中最后剩下的数)


/*
1、变量含义
  1）人数：n
  2）随机数：m
  3）小朋友编号：number
  4）报数：step
  5）剩余人数：count
  6）出列标记：array
2、排除无效情况
3、剩余人数不为0时，循环遍历
  1）编号累加
  2）编号超过人数时，编号归零
  3）对应编号已出列则跳过
  4）有效编号则报数累加
  5）报数等于随机数时，编号出列，报数归零，剩余人数减1
4、最后一个出列的编号即结果
 */
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        // 编号，报数，剩余人数
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
                // 剩余人数减1
                count--;
            }
        }
        return number;
    }
}
