// 316. 去除重复字母


/*
单调递增栈
实现思路：
1、利用单调递增栈，如果当前字符小于栈顶字符，则栈顶字符出栈，最后当前字符入栈，保证了栈内单调递增，删除了高位上较大的字符，使字典序更小
2、用inStack数组记录字符是否在栈中，存在则跳过，保证字母不重复
3、用count数组记录字符的个数，弹出时校验剩余个数，保证字母用一次，使字典序更小

算法过程：
1、遍历字符数组
  1）每遍历一个字符，该字符的剩余个数就减1
  2）如果字符已经在栈中，那么不能重复添加，需跳过
  3）栈不为空 且 当前字符小于栈顶字符 且 栈顶字符剩余个数大于0，那么弹出栈顶字符且记录不在栈中。
    判断 栈顶字符剩余个数大于0 是因为当前在高位弹出该字符能使字典序更小，但要满足每个字符出现一次，所以有剩余后面再加入，当前才可以弹出
  4）将当前字符入栈，并记录在栈中
2、栈不为空时，从栈底弹出字符拼凑字符串，返回字符串
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek()] > 0) {
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }
        return res.toString();
    }
}