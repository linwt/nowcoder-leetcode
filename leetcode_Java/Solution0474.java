// 474. 一和零


/*
动态规划，0-1背包，三维dp数组
1、题目：给你一个二进制字符串数组strs和两个整数m和n。请你找出并返回strs的最大子集的长度，该子集中最多有m个0和n个1。如果x的所有元素也是y的元素，集合x是集合y的子集。
2、题目简化：把总共的 0 和 1 的个数视为背包的容量，每一个字符串视为装进背包的物品。这道题就可以使用 0-1 背包问题的思路完成，这里的目标值是能放进背包的字符串的数量。
          求能够使用最多 m个0 和 n个1 的字符串的最大数量
3、定义dp数组：dp[k][i][j] 表示字符串数组的 前k个字符串 能够使用最多 i个0 和 j个1 的字符串的最大数量。
4、初始化：
  1）三维dp数组扩容：增加 空字符串、0个0、0个1 这一最小规模的情况
  2）创建三维dp数组时默认初始化为0，dp[0][i][j] = 0 表示前0个字符串是空字符串，能够使用最多i个0和j个1的字符串的最大数量为0
5、状态转移方程：
    if (i >= zero && j >= one)  dp[k][i][j] = Math.max(dp[k - 1][i][j], dp[k - 1][i - zero][j - one] + 1);    // 够放，比较“不放”和“放”的最大值
    else  dp[k][i][j] = dp[k - 1][i][j];       // 不够放，直接取“不放”的值
6、遍历dp数组填表：
    第一层遍历字符串数组，k从1开始，因为k为0的情况已经初始化好了，并计算当前字符串0和1的个数
    第二层遍历0的个数，i从0开始，因为“0”的个数可能为0
    第三次遍历1的个数，j从0开始，因为“1”的个数可能为0
7、返回结果：最后一个状态就是结果
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int k = 1; k <= len; k++) {
            int zero = 0, one = 0;
            for (char c : strs[k - 1].toCharArray()) {
                if (c == '0') zero++;
                else one++;
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i >= zero && j >= one) {
                        dp[k][i][j] = Math.max(dp[k - 1][i][j], dp[k - 1][i - zero][j - one] + 1);
                    } else {
                        dp[k][i][j] = dp[k - 1][i][j];
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}


/*
动态规划，0-1背包，二维dp数组。状态压缩，空间优化，滚动数组
1、定义dp数组：dp[i][j] 表示能够使用最多 i个0 和 j个1 的字符串的最大数量
2、初始化：
  1）二维dp数组扩容：增加 0个0、0个1 这一最小规模的情况，方便初始化
  2）创建二维dp数组时默认初始化为0，dp[0][0] = 0 表示能够使用最多 0个0 和 0个1 的字符串的最大数量为0
3、状态转移方程：dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
  1）等式右侧 dp[i][j] 表示 前k-1个字符串 能够使用最多 i个0 和 j个1 的字符串的最大数量
  2）等式右侧 dp[i - zero][j - one] 表示 前k-1个字符串 能够使用最多 i-zero个0 和 j-one个1 的字符串的最大数量，加1 表示在本轮中“放”第k个字符串 刚好使用 i个0 和 j个1 的字符串的最大数量
  3）等式左侧 dp[i][j] 表示 前k个字符串 能够使用最多 i个0 和 j个1 的字符串的最大数量
4、遍历dp数组填表
  1）遍历顺序
    ① 第一层遍历字符串数组，并计算当前字符串0和1的个数
    ② 第二层遍历0的个数，倒序遍历，只遍历 i >= zero 的情况
    ③ 第三层遍历1的个数，倒序遍历，只遍历 j >= one 的情况
  2）遍历理解
    ① 二维数组是滚动数组，每一轮滚动遍历中，未遍历的表示上一轮的旧状态，正在遍历的表示正在计算的状态，遍历过的表示本轮的新状态
    ② 本轮遍历中，背包容量不够放时，只能选择不放，旧状态就是“不放”，所以只遍历背包容量足够的情况即可(i >= zero && j >= one)
    ③ 倒序遍历是为了正确使用旧状态。如果是正序遍历就会在前面覆盖旧状态，求新状态时用到了前面被覆盖过的状态，表示的含义是物品重复使用，属于完全背包
5、返回结果：最后一个状态就是结果
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0, one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zero++;
                else one++;
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}