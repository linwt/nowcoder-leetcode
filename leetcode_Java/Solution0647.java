// 647. 回文子串


/*
与“5.最长回文子串”相似。本题是判断子串为回文串则数目加1
动态规划：
1、问题简化：求字符串s中回文子串的数目
2、定义dp数组：dp[l][r]表示子串s[l,r]是否为回文子串，l是左区间，r是右区间
3、初始化：
  1）二维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）boolean数组创建时，默认值是false，只需要标记为true的地方即可。可以初始化dp数组 dp[i][i] = true，表示1个字符是回文
4、状态转移方程：dp[l][r] = (s[l] == s[r]) and (r - l < 3 or dp[l + 1][r - 1])
   1）s[l] == s[r] 表示首尾两个字符相等
   2）r - l < 3 表示去掉首尾后剩余0或1个字符时仍是回文。作用包含了1个字符是回文，所以不用初始化dp数组单个字符为true
   3）dp[l + 1][r - 1] 表示去掉首尾后的区间是否回文
5、遍历dp数组填表：一个for遍历子串的右区间，另一个for循环遍历子串的左区间，顺序都是从左到右，根据状态转移方程推断计算未知结果并填表
6、返回结果：
  1）初始数目为字符串长度，即每个字符都是一个回文串
  2）遍历时是回文串时累加记录回文串数目，最后返回结果
 */
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l < 3 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    res++;
                }
            }
        }
        return res;
    }
}