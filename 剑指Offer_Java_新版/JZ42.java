// 42. 连续子数组的最大和


/*
动态规划：
1、题目简化：求连续子数组最大和
定义dp数组：dp[i] 表示以索引i结尾的连续子数组的最大和
2、初始化：dp[0] = array[0] 表示首元素结尾的最大和是对应元素值
3、状态转移方程
  1）每次遇到一个新元素，如果前面的连续子数组如果为正数，能提供收益，那么加上后当前元素结尾的连续子数组会变得更大，
    如果前面的连续子数组如果为负数，不能提供收益，那么直接丢弃，单独它本身会更大
  2）dp[i] = Math.max(dp[i - 1] + array[i], array[i])
4、遍历dp数组填表：从索引1开始遍历，根据状态转移方程填表
5、返回结果：最大的状态就是结果
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}


/*
贪心
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxNum = Arrays.stream(array).max().getAsInt();
        if (maxNum < 0) {
            return maxNum;
        }
        int maxSum = 0, curSum = 0;
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
