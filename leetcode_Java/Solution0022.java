// 22. 括号生成


/*
回溯：
1、画图，满二叉树，每个节点的 左子节点是(，右子节点是)
1、剪枝：左括号大于n，右括号大于左括号，这两种情况是非有效括号
2、终止条件：字符串长度为2n，表示到达了叶子结点，满足条件，收集结果
3、递归：每次加一个左括号或加一个右括号，然后进入下一层，并记录左括号或右括号的数量
 */
class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, 0, 0);
        return res;
    }

    private void dfs(String track, int n, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (track.length() == 2 * n) {
            res.add(track);
            return;
        }
        dfs(track + "(", n, left + 1, right);
        dfs(track + ")", n, left, right + 1);
    }
}


/*
动态规划：
1、在求N个括号的排列组合时，把第N种情况（也就是N个括号排列组合）视为单独拿一个括号E出来，剩下的N-1个括号分为两部分，
  P个括号和Q个括号，P+Q=N-1，然后这两部分分别处于括号E内和括号E的右边，各自进行括号的排列组合。
  由于我们是一步步计算得到N个括号的情况的，所以小于等于N-1个括号的排列组合方式我们是已知的
  （用合适的数据结构存储，方便后续调用，且在存储时可利用特定数据结构实现题目某些要求，如排序，去重等），
  且P+Q=N-1，P和Q是小于等于N-1的，所以我们能直接得到P个和Q个括号的情况，进而得到N个括号的结果！
2、dp[i]表示i组括号的所有有效组合
3、dp[i] = "(" + dp[p]的组合 + ")" + dp[q]的组合"，其中1+p+q=i，p从0遍历到i-1，q则相应从i-1到0
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<String>> dp = new LinkedList<>();
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("");
        dp.add(list1);
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("()");
        dp.add(list2);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> l1 = dp.get(j);
                List<String> l2 = dp.get(i - 1 - j);
                for (String s1 : l1) {
                    for (String s2 : l2) {
                        String s = "(" + s1 + ")" + s2;
                        temp.add(s);
                    }
                }
            }
            dp.add(temp);
        }
        return dp.get(n);
    }
}