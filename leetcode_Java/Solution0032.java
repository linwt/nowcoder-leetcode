// 32. 最长有效括号


/*
栈：
1、通过栈，可以在遍历字符串的过程中去判断到目前为止扫描的子串的有效性，同时能得到最长有效括号的长度
2、始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标
3、先初始化栈，往栈中放入一个值为 −1 的元素，表示「最后一个没有被匹配的右括号的下标」
4、遇到'('时将它的下标入栈
5、遇到')'时，先弹出栈顶元素表示匹配了当前右括号
  1）如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新「最后一个没有被匹配的右括号的下标」
  2）如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
 */
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}


/*
贪心，计数：
1、正向遍历，统计左括号和右括号的数量
  当数量相等时说明凑成了有效括号，此时计算子串长度并更新最长长度
  当右括号数量大于左括号数量时，那么前面遍历过的括号将无法再凑成有效括号，因此前面作废，计数归零，重新开始计算有效括号长度
2、反向遍历同上，当左括号数量大于右括号数量时重新计算
3、双向遍历的原因
  1）s = "())" 正向遍历才有左右括号数量相等的时候
  2）s = "(()" 反向遍历才有左右括号数量相等的时候
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0, left = 0, right = 0, reverseLeft = 0, reverseRight = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                res = Math.max(res, 2 * left);
            } else if (right > left) {
                left = right = 0;
            }

            if (s.charAt(n - 1 - i) == '(') {
                reverseLeft++;
            } else {
                reverseRight++;
            }
            if (reverseLeft == reverseRight) {
                res = Math.max(res, 2 * reverseLeft);
            } else if (reverseLeft > reverseRight) {
                reverseLeft = reverseRight = 0;
            }
        }
        return res;
    }
}


/*
动态规划：
1、定义dp数组：dp[i]表示 以索引i的字符结尾的子串 形成的最长有效括号的长度
2、初始化：默认为0，不用初始化
3、状态转移方程：
  1）跳过前一字符结尾的最长有效括号的范围，找到与当前括号匹配的左括号的位置，如果该位置有效且确实是左括号，
    那么产生了一对有效括号，数量为 前一字符结尾的最长有效括号长度 加2，即 dp[i] = dp[i - 1] + 2
  2）在当前字符为有效括号的基础上，再把 当前字符结尾的有效括号范围 前面的有效括号长度 加上，得到 当前字符结尾的最长有效括号的长度
4、遍历dp数组填表：从索引1开始遍历，因为dp[0]只有一个字符构不成有效括号，当遇到右括号时开始计算填表
5、返回结果：最大的状态就是结果

   (  )  (  (  )  (  )  )
      ↑  ↑              ↑
   pre-1 pre            i
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                int preLen = dp[i - 1];
                int pre = i - 1 - preLen;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (pre - 1 >= 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}