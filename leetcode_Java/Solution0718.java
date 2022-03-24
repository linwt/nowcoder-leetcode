// 718. 最长重复子数组


/*
动态规划：
1、题目简化：求数组nums1和nums2中最长公共子数组的长度。注意子数组是连续的。（也可以理解成 求两个字符串的最长公共连续子串的长度）
2、定义dp数组：dp[i][j] 表示 nums1第i个元素结尾 和 nums2第j个元素结尾 的最长公共子数组的长度
3、初始化：
  1）二维dp数组扩容：增加空数组这一最小规模的情况，方便直观初始化
  2）dp[i][0] = dp[0][j] = 0 表示 空数组 和 任意数组 的最长公共子数组的长度为0。
4、状态转移方程：
  1）如果 nums1[i] == nums2[j]，即两个元素相同时，结果为 nums1第i-1个元素结尾 和 nums2第j-1个元素结尾 的最长公共子数组的长度 加1，即 dp[i][j] = dp[i - 1][j - 1] + 1;
  2）如果 nums1[i] != nums2[j]，即两个元素不相同时，以这两个元素结尾的子数组也必然不相同，所以公共子数组的长度为0
5、遍历dp数组填表：
  1）两个for循环遍历二维dp数组每个位置，根据状态转移方程计算该位置的最长公共子数组的长度
  2）遍历顺序决定了哪些位置是计算过的、是已知状态，外层遍历数组nums1，内层遍历数组nums2。
    从二维数组角度看，遍历顺序是从上到下，从左到右，所以遍历到(i,j)位置时，其左方、上方、左上方状态都已经遍历计算过了。
    从两个字符串角度看，两个指针分别指向两个数组，两者遍历顺序都是从左到右，所以遍历到(i,j)位置时，其左边其他位置都遍历计算过了。
    所以求 dp[i][j] 时，dp[i - 1][j - 1]、dp[i - 1][j]、dp[i][j - 1] 都是已知状态了
6、返回结果：遍历过程比较并记录最长公共子数组的长度，最后返回结果

nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7], findLength = 3
    [] 3  2  1  4  7
[]  0  0  0  0  0  0
1   0  0  0  1  0  0
2   0  0  1  0  0  0
3   0  1  0  0  0  0
2   0  0  2  0  0  0
1   0  0  0  3  0  0

nums1: 1  2  3  2  1
                   ↑
                   i
nums2: 3  2  1  4  7
             ↑
             j
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, res = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }
}


/*
如果是求“最长重复子序列”，即不要求连续，则解法如下。解法与“1143.最长公共子序列”相同
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}