// 139. 单词拆分


/*
动态规划：
1、dp[i]表示前i个字符是否能由单词拼出
2、初始化：dp[0] = true，方便递推判断
3、状态转移方程：dp[i] = dp[j] && wordDict.contains(s.substring(j, i))
4、遍历顺序：固定未知位置，由前面已知推断当前结果。固定第i个字符的位置，然后从头开始遍历到i位置，判断s[0,j)和s[j,i)是否能由单词拼出
5、当dp[i]找到一个成功结果时就可以结束循环了
6、i、j的使用：两个for循环中i、j是用于遍历dp数组的，表示dp数组的索引，dp数组的长度比字符串s 大1，用于初始化，字符串s要用i、j时需要根据情况转换成s对应的索引

dp      □□□□□□
索引     012345
s        apple
索引      01234
位置      12345
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}


/*
动态规划：
1、dp[i]表示前i个字符是否能由单词拼出
2、初始化：dp[0] = true，方便递推判断
3、状态转移方程：dp[m] = dp[i] && m <= n && s.startsWith(word, i)
4、遍历顺序：固定已知位置，推断后面位置结果。固定第i个字符的位置，且该位置能由单词拼出，然后遍历单词数组，判断扩增一个单词长度的子串是否为s的子串，是则该子串能由单词拼出
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                int m = i + word.length();
                if (m <= n && s.startsWith(word, i)) {
                    dp[m] = true;
                }
            }
        }
        return dp[n];
    }
}