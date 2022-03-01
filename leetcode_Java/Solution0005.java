// 最长回文子串


/*
暴力破解：列举所有的子串，判断是否为回文串，保存最长的回文串
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + maxLen; j <= len; j++) {
                String sub = s.substring(i, j);
                int subLen = sub.length();
                if (isPalindrome(sub) && subLen > maxLen) {
                    res = sub;
                    maxLen = subLen;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        for (int l = 0, r = s.length() - 1; l < r; )
        return true;
    }

    // 方法同上，使用for替代while
    private boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}


/*
中心扩散：
1、遍历字符，以当前字符为中心向两边扩散，包括奇数和偶数回文串两种中心，得到当前中心的回文串长度
2、比较并记录所有中心的最长回文串长度和对应起点，最后截取并返回最长回文子串
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroudCenter(s, i, i);
            int evenLen = expandAroudCenter(s, i, i + 1);
            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                start = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expandAroudCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}


/*
动态规划：
1、回文天然具有「状态转移」性质：一个长度大于 2 的回文去掉头尾字符以后，剩下的部分依然是回文。
   反之，如果一个字符串头尾两个字符都不相等，那么这个字符串一定不是回文。「动态规划」的方法根据这样的性质得到。
2、动态规划是暴力破解的优化，两者同样需要遍历列举判断所有子串是否为回文串，
   区别是暴力破解每次都要对子串单独处理判断是否为回文串，动态规划可以利用之前记录的子串结果直接判断当前子串是否为回文串
3、boolean数组创建时，默认值是false，只需要标记为true的地方即可
4、dp[l][r]表示子串s[l,r]是否为回文子串，l是左区间，r是右区间
5、状态转移方程：dp[l][r] = (s[l] == s[r]) and (r - l < 3 or dp[l + 1][r - 1])
   s[l] == s[r] 表示首尾两个字符相等
   r - l < 3 表示去掉首尾后剩余0或1个字符时仍是回文。作用包含了1个字符是回文，所以不用初始化dp数组的对角线为true
   dp[l + 1][r - 1] 表示去掉首尾后的区间是否回文
6、dp[l][r]是回文时，则比较并记录最长回文串的长度和首尾位置
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1, start = 0, end = 0;
        boolean[][] dp = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l < 3 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}