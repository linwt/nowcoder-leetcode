// 分割回文串


/*
回溯：
1、使用res存放全局结果，使用track存放子结果
2、调用递归函数处理得到结果，返回结果
3、定义递归函数：
   1）终止条件：字符串遍历结束，收集子结果
   2）剪枝条件：子串是否回文串，不是则跳过，是则递归下一层处理
   3）单层递归逻辑：遍历字符串，得到一个区间的子串，判断子串是否回文串，是则添加子串到track中，递归下一层处理剩余的字符串，回溯撤销当前层在track添加的子串
 */
class Solution {
    private List<List<String>> res = new ArrayList<>();
    private Deque<String> track = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                track.addLast(s.substring(startIndex, i + 1));
                backtrack(s, i + 1);
                track.removeLast();
            }
        }
    }

    // 是否回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}