// 139. 单词拆分


/*
动态规划：
1、题目：给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s。注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
2、题目简化：字符串s能否由单词列表拼出
3、定义dp数组：dp[i]表示前i个字符是否能由单词拼出
4、初始化：
  1）一维dp数组扩容：增加空字符串这一最小规模的情况，方便初始化
  2）dp[0] = true，表示字符串为空字符时的情况，方便递推判断
5、状态转移方程：dp[i] = dp[j] && wordDict.contains(s.substring(j, i))
6、遍历dp数组填表：
  1）解释一：第一个for循环用于遍历dp数组未知位置，第二个for循环用于遍历dp数组已知位置，得到已知结果后根据状态转移方程推断计算未知结果并填表
  2）解释二：固定未知位置，由前面已知推断当前结果。固定第i个字符的位置，然后从头开始遍历到i位置，判断s[0,j)和s[j,i)是否能由单词拼出
  3）i、j的使用：两个for循环中i、j是用于遍历dp数组的，表示dp数组的索引，dp数组的长度比字符串s 大1，用于初始化，字符串s要用i、j时需要根据情况转换成s对应的索引
7、返回结果：最后一个状态就是结果

dp        □ □ □ □ □ □
dp索引     0 1 2 3 4 5
s           a p p l e
s索引        0 1 2 3 4
s位置        1 2 3 4 5
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
1、题目简化：字符串s能否由单词列表拼出
2、定义dp数组：dp[i]表示前i个字符是否能由单词拼出
3、状态转移方程：dp[m] = dp[i] && m <= n && s.startsWith(word, i)
4、初始化：dp[0] = true，表示字符串为空字符时的情况，方便递推判断
5、遍历dp数组填表：
  1）解释一：第一个for循环用于遍历dp数组，第二个for循环用于遍历单词数组，根据状态转移方程推断计算未知结果并填表
  2）解释二：固定已知位置，推断后面位置结果。固定第i个字符的位置，且该位置能由单词拼出，然后遍历单词数组，判断扩增一个单词长度的子串是否为s的子串，是则该子串能由单词拼出
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


/*
广度优先：
1、memo[i]表示前i个字符是否能由单词拼出
2、队列queue存放的是dp[i]的索引i，前i个字符能由单词拼出，再继续判断后面的字符
3、从队列弹出一个起始索引，遍历单词数组，根据单词扩增子串长度，判断子串长度是否合法、dp是否标记过，是否为s的子串、长度是否达到s的长度，
  满足条件则返回true，否则为有效子串就加入队列继续判断，并标记该子串位置能由单词拼出
4、遍历结束都不满足则返回false
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int start = queue.poll();
                for (String word : wordDict) {
                    int nextStart = start + word.length();
                    if (nextStart > n || memo[nextStart]) {
                        continue;
                    }
                    if (s.startsWith(word, start)) {
                        if (nextStart == n) {
                            return true;
                        }
                        memo[nextStart] = true;
                        queue.add(nextStart);
                    }
                }
                size--;
            }
        }
        return false;
    }
}


/*
深度优先：
1、memo[i]表示前i个字符是否能由单词拼出。被标记为true表示子串能由单词拼出，但是最终不能拼出s，因为递归是一次性判断是否成功，所以该标记用于避免重复处理
2、dfs(start) 输入参数表示前start个字符能由单词拼出，输出 前start个字符分别拼接单词数组的单词后的子串，是否为s的子串
3、终止条件：子串有效且达到s的长度时返回true，拼接单词的子串都无效时返回false
4、调用递归函数：子串有效但未达到s的长度，递归判断子串继续拼接单词后，是否有效且达到s的长度
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        return dfs(s, wordDict, 0, memo);
    }

    private boolean dfs(String s, List<String> wordDict, int start, boolean[] memo) {
        for (String word : wordDict) {
            int nextStart = start + word.length();
            if (nextStart > s.length() || memo[nextStart]) {
                continue;
            }
            if (s.startsWith(word, start)) {
                if (nextStart == s.length() || dfs(s, wordDict, nextStart, memo)) {
                    return true;
                }
                memo[nextStart] = true;
            }
        }
        return false;
    }
}