// 312. 戳气球


/*
动态规划：
1、题目简化：求戳破所有气球能获得硬币的最大数量
2、定义dp数组：
  1）dp[start][end] 表示在开区间 (start,end) 能得到的最大硬币数
  2）“开区间” 的意思是只能戳爆 start 和 end 之间的气球，start 和 end 不能戳
  3）先别管前面是怎么戳的，只要管这个区间最后一个被戳破的是哪个气球，用 k 表示这个区间最后一个被戳爆的气球的索引
3、初始化
  1）气球数组的边界是数字1的气球，所以直接数组扩容首尾两个元素为1
  2）dp数组不用初始化，默认为0，表示获得硬币的最大数量为0
4、状态转移方程
  1）因为 k 是最后一个被戳爆的气球，所以它两边没有气球了，只有这个开区间首尾的 start 和 end 了，这就是为什么DP的状态转移方程是只和 start 和 end 位置的数字有关
  2）因为 k 是最后一个被戳爆的气球，所以左右两边的气球已经被戳爆了，且左右两边互不干扰，所以计算区间能得到的硬币数就需要把左右两边能得到的硬币数加上
    戳爆k后开区间(start,end)能得到的硬币数 = 开区间(start,k)能得到的最大硬币数 + 戳爆k的得到的硬币数 + 开区间(k,end)能得到的最大硬币数
    即 total = dp[start][k] + temp[start] * temp[k] * temp[end] + dp[k][end]
  3）由于区间 (start,end) 内每个气球都可以作为最后一个被戳爆的气球，所以把每个当成最后一个被戳爆的气球计算区间能得到的硬币数，最后取最大值就得到了在开区间 (start,end) 能得到的最大硬币数
5、遍历dp数组填表
  第一个for循环遍历区间长度，从最小的长度3开始
  第二个for循环遍历区间的起始端点
  第三个for循环遍历区间内最后一个被戳爆的气球
6、返回结果：包含整个气球数组范围的状态就是结果

nums = [3,8,5]
temp = [1,3,8,5,1]

由小问题推到大问题：
   1  3  8  5  1
   ↑_____↑
start   end
======================
   1  3  8  5  1
      ↑_____↑
======================
   1  3  8  5  1
         ↑_____↑
======================
   1  3  8  5  1
   ↑________↑
======================
   1  3  8  5  1
      ↑________↑
======================
   1  3  8  5  1
   ↑___________↑
 */
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        System.arraycopy(nums, 0, temp, 1, n);
        temp[0] = temp[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int start = 0; start <= n + 2 - len; start++) {
                int res = 0;
                int end = start + len - 1;
                for (int k = start + 1; k < end; k++) {
                    res = Math.max(res, dp[start][k] + temp[start] * temp[k] * temp[end] + dp[k][end]);
                }
                dp[start][end] = res;
            }
        }
        return dp[0][n + 1];
    }
}