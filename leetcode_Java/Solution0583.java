// 583. 两个字符串的删除操作


/*
动态规划：
1、题目简化：求使word1和word2相同的最少删除次数
2、定义dp数组：dp[i][j] 表示使 word1前i个字符 和 word2前j个字符 相同的最少删除次数
3、初始化：
  1）二维dp数组扩容：增加空字符串这一最小规模的情况，方便直观初始化
  2）dp[i][0] = i 表示使 word1前i个字符 和 空字符串 相同的最少删除次数为i
     dp[0][j] = j 表示使 空字符 和 word2前j个字符 相同的最少删除次数为j
4、状态转移方程：
  1）如果word1[i] == word2[j]，即两个字符串最后一个字符相同，那么不用删除，结果为 word1前i-1个字符 和 word2前j-1个字符 相同的最少删除次数，即 dp[i][j] = dp[i - 1][j - 1];
  2）如果word1[i] != word2[j]，即两个字符串最后一个字符不相同，那么需要一次删除操作，使用之前状态的最少删除次数加1，有两种情况是状态已知且字符最多的
    ① 删除word1[i]，即 word1前i-1个字符 和 word2前j个字符 相同的最少删除次数 加1，即 dp[i - 1][j] + 1
    ② 删除word2[j]，即 word1前i个字符 和 word2前j-1个字符 相同的最少删除次数 加1，即 dp[i][j - 1] + 1
    比较这两种情况是因为删除的字符可能是相同的字符，会增加额外的删除操作，两者取最少就得到当前结果，即 dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
5、遍历dp数组填表
  1）两个for循环遍历二维dp数组每个位置，根据状态转移方程计算该位置的最少删除次数
  2）遍历顺序决定了哪些位置是计算过的、是已知状态，外层遍历字符串word1，内层遍历字符串word2。
    从二维数组角度看，遍历顺序是从上到下，从左到右，所以遍历到(i,j)位置时，其左方、上方、左上方状态都已经遍历计算过了。
    从两个字符串角度看，两个指针分别指向两个字符串，两者遍历顺序都是从左到右，所以遍历到(i,j)位置时，其左边其他位置都遍历计算过了。
    所以求 dp[i][j] 时，dp[i - 1][j - 1]、dp[i - 1][j]、dp[i][j - 1] 都是已知状态了
6、返回结果：最后一个状态就是结果

word1 = "leetcode", word2 = "letgo", minDistance = 5
   '' l  e  t  g  o
'' 0  1  2  3  4  5
l  1  0  1  2  3  4
e  2  1  0  1  2  3
e  3  2  1  2  3  4
t  4  3  2  1  2  3
c  5  4  3  2  3  4
o  6  5  4  3  4  3
d  7  6  5  4  5  4
e  8  7  6  5  6  5

        word1[i] == word2[j]          word1[i] != word2[j]
word1:  l  e  e  t  c  o  d  e       l  e  e  t  c  o  d  e
                 ↑                               ↑
                 i                               i
word2:  l  e  t  g  o                l  e  t  g  o
              ↑                            ↑
              j                            j
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}


/*
问题转化成“1143.最长公共子序列”，两个字符串除了公共部分，剩余的字符就是要删除的次数
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n + m - 2 * dp[n][m];
    }
}