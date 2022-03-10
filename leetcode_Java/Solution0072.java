// 72. 编辑距离


/*
动态规划：自底向上
1、dp[i][j] 表示 word1 前 i 个字符转换成 word2 前 j 个字符使用的最少操作数
   注意第 i 个字符在字符串中为 word1.charAt(i - 1)，索引从0开始
2、初始化：
  1）针对首行首列要单独考虑，引入''。列表示word1，行表示word2
  2）第一行是word1为空，word1转换成word2使用的最少操作数，就是插入操作
  3）第一列是word2为空，word1转换成word2使用的最少操作数，就是删除操作
3、状态转移方程：
  1）当 word1[i] == word2[j]，由于遍历到了i、j，说明 word1 的 0~i-1 和 word2 的 0~j-1 的匹配结果已经生成，当前两个字符相同，无需任何操作，因此 dp[i][j] = dp[i - 1][j - 1];
  2）当 word1[i] != word2[j]
     ① 替换：word1 的 0~i-1 位置与 word2 的 0~j-1 位置的字符都相同，只是当前位置的字符不匹配,进行替换操作后两者变得相同，因此 dp[i][j] = dp[i - 1][j - 1] + 1;
     ② 删除：若此时 word1 的 0~i-1 位置与 word2 的 0~j 位置已经匹配了，此时多出了 word1 的 i 位置字符，应把它删除掉两者才变得相同，因此 dp[i][j] = dp[i - 1][j] + 1;
     ③ 插入：若此时 word1 的 0~i 位置只是和 word2 的 0~j-1 位置匹配，此时只需要在 word1 的 i 位置后面插入一个和 word2 的 j 位置相同的字符，使得两者变得相同，因此 dp[i][j] = dp[i][j - 1] + 1;
     注：加1表示执行一次操作
4、以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1 的前 5 个字符转换为 word2 的前 3 个字符，也就是将 horse 转换为 ros，因此有：
  1）dp[i-1][j-1] 表示替换操作，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将 word1 第五个字符替换成 word2 的第三个字符，即由 e 替换为 s
  2）dp[i][j-1] 表示删除操作，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾插入一个 s
  3）dp[i-1][j] 表示插入操作，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符

   ''  r   o   s
'' 0   1   2   3
h  1   1   2   3
o  2   2   1   2
r  3   2   2   2
s  4   3   3   2
e  5   4   4   3
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}



/*
递归：自顶向下
1、定义并初始化备忘录数组，作用相当于dp数组
2、使用两个指针i、j分别指向两个字符串的末尾，逐步向前移动
3、定义递归函数
  1）函数定义：dfs(i,j) 输入参数 word1 的位置 i 和 word2 的位置 j，返回 word1[0..i] 和 word2[0..j] 的最小编辑距离
  2）终止条件：一个字符串遍历完，则返回另一个字符剩余字符个数，表示全部删除或全部插入，都刚好遍历完则是返回0
  3）查找备忘录，有计算过则快速返回
  4）调用递归函数计算(i,j)的最小编辑距离，结果保存在备忘录中，并返回结果

word1：  h  r  o  s  e
                     ↑
                     i
word2：  r  o  s
               ↑
               j
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(word1, word2, n - 1, m - 1, memo);
    }

    private int dfs(String word1, String word2, int i, int j, int[][] memo) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dfs(word1, word2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = 1 + Math.min(dfs(word1, word2, i - 1, j - 1, memo), Math.min(dfs(word1, word2, i, j - 1, memo), dfs(word1, word2, i - 1, j, memo)));
        }
        return memo[i][j];
    }
}