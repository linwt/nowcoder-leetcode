// 402. 移掉 K 位数字


/*
单调递增栈：
1、最小的数字就是尽可能保证高位数字更小且升序，所以要删除高位较大的数字。
  利用单调递增栈的特性，栈内元素升序，遇到比栈顶元素小的数时 栈顶元素出栈，小数入栈，这样在某一高位上就用小数替代了大数，使整体数字更小
2、遍历数字
  1）栈不为空 且 当前数字小于栈顶数字 且 仍可移除数字，弹出栈顶数字，循环处理直到不满足条件
  2）栈不为空 或 数字不为0，则数字入栈，保证了栈底数字不为0
3、遍历结束后如果没删够k个数字，那么继续从栈顶弹出元素，即删除低位数字
4、从栈底弹出元素，拼凑字符串。如果字符串为空则返回"0"，否则返回该字符串
 */
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            if (c != '0' || !stack.isEmpty()) {
                stack.push(c);
            }
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            if (k > 0) {
                stack.pop();
                k--;
            } else {
                res.append(stack.pollLast());
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}