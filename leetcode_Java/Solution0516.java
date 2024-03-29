// 516. 最长回文子序列


/*
动态规划：
1、题目简化：求字符串s的最长回文子序列的长度
2、定义dp数组：dp[l][r] 表示字符串在区间s[l,r]的最长回文子序列的长度
3、初始化：
  1）二维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）dp[i][i] = 1 表示每个字符的最长回文子序列的长度为1
4、状态转移方程：
  1）如果s[l] == s[r]，即区间首尾两个字符相同，由于l<r，所以有两种情况
     ① 两个字符相邻，中间没有字符，则 r-l == 1，此时最长回文子序列的长度为2个字符，即 dp[l][r] = 2
     ② 两个字符不相邻，中间有字符，那么结果为 中间的字符的最长回文子序列的长度加2个字符，即 dp[l][r] = dp[l + 1][r - 1] + 2
  2）如果s[l] != s[r]，即区间首尾两个字符不相同，那么长度不能增加，只能使用之前状态的最长长度，有两种情况是状态已知且字符最多的
     ① 去掉s[l]，即区间s[l+1,r]的最长回文子序列的长度，即dp[l + 1][r]
     ② 去掉s[r]，即区间s[l,r-1]的最长回文子序列的长度，即dp[l][r - 1]
     比较这两种情况是因为去掉的字符可能刚好是一个回文字符，两者取最大就得到当前结果，即 dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1])
5、遍历dp数组填表：
  1）两个for循环遍历二维dp数组右上角每个位置，根据状态转移方程计算该位置的最长回文子序列的长度
  2）遍历顺序决定了哪些位置是计算过的、是已知状态，外层遍历右区间，内层遍历左区间。
    从二维数组角度看，遍历顺序是从左到右，从下到上，所以遍历到(l,r)位置时，其左方、下方、左下方状态都已经遍历计算过了。
    从字符串角度看（更好理解），两个指针分别指向字符串的左右区间，右指针 从左到右遍历，左指针 从右到左遍历，所以遍历到(l,r)位置时，其中间其他位置都遍历计算过了。
    由于新状态的转移需要依赖 不含首尾的中间区间 和 含首尾之一的中间区间 的旧状态，所以决定了这样的遍历顺序
    所以求 dp[l][r] 时，dp[l + 1][r - 1]、 dp[l + 1][r]、dp[l][r - 1]都是已知状态了
6、返回结果：遍历过程比较并记录每个区间中的最长回文子序列的长度，最终返回最大值

s = "bdccbe", lps = "bccb"
   b  d  c  c  b  e
b  1  1  1  2  4  4
d     1  1  2  2  2
c        1  2  2  2
c           1  1  1
b              1  1
e                 1


b  d  c  c  b  e
      ↑  ↑
      l  r

b  d  c  c  b  e
↑           ↑
l           r

b  d  c  c  b  e
↑              ↑
l              r
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), res = 1;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int r = 1; r < n; r++) {
            for (int l = r - 1; l >= 0; l--) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l == 1) {
                        dp[l][r] = 2;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1] + 2;
                    }
                    res = Math.max(res, dp[l][r]);
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
            }
        }
        return res;
    }
}