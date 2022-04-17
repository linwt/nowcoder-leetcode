// 10. 正则表达式匹配


/*
1、定义dp数组：dp[i][j] 表示 s 的前 i 个字符是否能被 p 的前 j 个字符匹配
2、初始化
  1）s为空，p为空，能匹配
  2）p为空，s不为空，不能匹配。boolean数组默认值为false，无需处理
  3）s为空，p不为空，由于*可以匹配0个字符，所以可能匹配
3、状态转移方程
  1）s[i]是{字母}，p[j]是{字母，点，星}
  2）s[i]字母 与 p[j]字母：两者相等则dp[i][j]看前一项即可，所以dp[i][j] = dp[i-1][j-1]。两者不等则不能匹配
  3）s[i]字母 与 p[j]点：点能配任何一个字母，所以两者必然相等，所以dp[i][j]看前一项即可，所以dp[i][j] = dp[i-1][j-1]
  4）s[i]字母 与 p[j]星：星代表零个或多个前面的那一个元素
    ① 若为0个，匹配0次的情况，则代表删掉了p[j-1]和p[j]，所以此时dp[i][j] = dp[i][j-2]
    ③ 若为多个，匹配1次或多次的情况，如果s[i] == p[j-1] || p[j-1] == '.'，即s的末尾字符与p的末尾前一字符匹配，
      那么可以忽略s的末尾字符，因为p的末尾可以匹配1个或多个，此时dp[i][j] = dp[i-1][j]
4、遍历dp数组填表：第一个for循环遍历字符串s，第二个for循环遍历字符串p
5、返回结果：最后一个状态就是结果

======== 3-2 =========
s = "abc", p = "abc"
       ↑          ↑
       i          j
======== 3-3 =========
s = "abc", p = "ab."
       ↑          ↑
       i          j
======== 3-4-1 =======
s = "a", p = "ab*"
     ↑          ↑
     i          j
======== 3-4-2 =======
s = "acc", p = "ac*"
       ↑          ↑
       i          j
s = "acc", p = "ac*"
      ↑           ↑
      i           j
s = "acc", p = "ac*"
     ↑            ↑
     i            j
======== 3-4-2 =======
s = "acc", p = "a.*"
       ↑          ↑
       i          j
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= n; i += 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                char pcPre = p.charAt(j - 2);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == pcPre || pcPre == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}