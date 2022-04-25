// 301. 删除无效的括号


/*
回溯：
1、题目要求将所有最长合法方案输出，因此不可能有别的优化，只能进行「爆搜」，可以使用 DFS 实现回溯搜索
2、所有的合法方案，必然有左括号的数量与右括号数量相等。令左括号的得分为 1；右括号的得分为 −1。则合法方案会有如下性质：
  1）对于一个合法的方案而言，必然有最终得分为 0；
  2）搜索过程中不会出现得分值为 负数 的情况，即右括号数量大于左括号数量时为非法
3、预处理出「爆搜」过程的最大得分：maxScore = min(左括号的数量, 右括号的数量)，即合法左括号先全部出现在左边，之后使用最多的合法右括号进行匹配
4、枚举过程中出现字符分三种情况：
  1）左括号：如果增加当前 ( 后，仍为合法子串，即 score+1 <= maxscore 时，我们可以选择添加该左括号，也能选择不添加
  2）右括号：如果增加当前 ) 后，仍为合法子串，即 score-1 >= 0 时，我们可以选择添加该右括号，也能选择不添加
  3）普通字符：直接添加
5、使用 Set 进行方案去重，maxLen 记录「爆搜」过程中的最大子串，然后只保留长度等于 maxLen 的子串
6、回溯过程的公共变量作为成员变量，方法独有的变量作为局部变量
7、定义递归函数：
  1）剪枝条件：分数score非法，即左括号或右括号的数量多了
  2）终止条件：遍历完字符串，判断 分数是否为0、子串长度是否大于等于当前最大长度，若大于最大长度则更新最大长度，并清空集合，最后将将子串加入集合
  3）递归回溯：遍历字符，调用递归方法构造并校验子串。由于变量的改变在入参处理，所以递归结束后 下一个递归参数仍然使用原变量处理，多个递归方法参数互不影响，即回溯
  4）入参变化：
    ① 一次递归即遍历下一个字符，索引index加1
    ② 添加左括号时，分数score加1，子串subs加上该字符。不添加时分数score不变，子串subs不变
    ③ 添加右括号时，分数score减1，子串subs加上该字符。不添加时分数score不变，子串subs不变
    ④ 字母必须添加，分数score不变，子串subs加上该字符
 */
class Solution {
    int n, maxScore, maxLen;
    String s;
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        n = s.length();
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
        }
        maxScore = Math.min(left, right);
        track(0, 0, "");
        return new ArrayList<>(set);
    }

    private void track(int index, int score, String subs) {
        if (score < 0 || score > maxScore) {
            return;
        }
        if (index == n) {
            if (score == 0 && subs.length() >= maxLen) {
                if (subs.length() > maxLen) {
                    maxLen = subs.length();
                    set.clear();
                }
                set.add(subs);
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            track(index + 1, score + 1, subs + String.valueOf(c));
            track(index + 1, score, subs);
        } else if (c == ')') {
            track(index + 1, score - 1, subs + String.valueOf(c));
            track(index + 1, score, subs);
        } else {
            track(index + 1, score, subs + String.valueOf(c));
        }
    }
}


/*
1、上一解法是在搜索过程中去更新最后的 maxLen，但实际上可以通过预处理，得到最后的「应该删除的左括号数量」和「应该删掉的右括号数量」，来直接得到最终的 maxLen，因此可以多增加一层剪枝
2、遍历字符串时，对左括号数量和右括号数量进行匹配抵消，最终剩下的数量就是应该删除的括号数量，由字符串长度 减去 应该删除的括号数量 得到 最终子串长度
3、定义递归函数：
  1）剪枝条件：分数score非法，即左括号或右括号的数量多了。应该删除括号数量非法，即删多了
  2）校验合法条件：应该删除括号数量为0、子串长度等于最大长度，则将子串加入集合
  3）终止条件：遍历完字符串，索引等于字符串长度
  4）递归回溯：遍历字符，调用递归方法构造并校验子串。由于变量的改变在入参处理，所以递归结束后 下一个递归参数仍然使用原变量处理，多个递归方法参数互不影响，即回溯
  5）入参变化：
    ① 一次递归即遍历下一个字符，索引index加1
    ② 添加左括号时，分数score加1，子串subs加上该字符。不添加时分数score不变，子串subs不变
    ③ 添加右括号时，分数score减1，子串subs加上该字符。不添加时分数score不变，子串subs不变
    ④ 字母必须添加，分数score不变，子串subs加上该字符
    ⑤ 不添加左括号时，应该删除左括号数量leftDel减1。添加时则不变
    ⑥ 不添加右括号时，应该删除右括号数量rightDel减1。添加时则不变
 */
class Solution {
    int n, maxScore, maxLen;
    String s;
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        n = s.length();
        int left = 0, right = 0;
        int leftDel = 0, rightDel = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                leftDel++;
            } else if (c == ')') {
                right++;
                if (leftDel != 0) {
                    leftDel--;
                } else {
                    rightDel++;
                }
            }
        }
        maxScore = Math.min(left, right);
        maxLen = n - leftDel - rightDel;
        track(0, 0, leftDel, rightDel, "");
        return new ArrayList<>(set);
    }

    private void track(int index, int score, int leftDel, int rightDel, String subs) {
        if (leftDel < 0 || rightDel < 0 || score < 0 || score > maxScore) {
            return;
        }
        if (leftDel == 0 && rightDel == 0 && subs.length() == maxLen) {
            set.add(subs);
        }
        if (index == n) {
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            track(index + 1, score + 1, leftDel, rightDel, subs + String.valueOf(c));
            track(index + 1, score, leftDel - 1, rightDel, subs);
        } else if (c == ')') {
            track(index + 1, score - 1, leftDel, rightDel, subs + String.valueOf(c));
            track(index + 1, score, leftDel, rightDel - 1, subs);
        } else {
            track(index + 1, score, leftDel, rightDel, subs + String.valueOf(c));
        }
    }
}