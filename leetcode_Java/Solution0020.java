// 20. 有效的括号


/*
思路：
1、括号有序，即使多层嵌套也必然至少有一对相邻有序出现，从内部逐层抵消
2、使用while循环判断字符串的相邻有序对
 */
class Solution {
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            }
            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }
            if ( s.contains("[]")) {
                s = s.replace("[]", "");
            }
        }
        return s.isEmpty();
    }
}


/*
思路：
1、使用HashMap存放括号对，方便映射获取
2、由括号的顺序特点，使用栈存放左括号，以后进先出的方式与右括号抵消
3、字符串使用for循环遍历处理每个字符，维护一个栈，碰到左括号就入栈，碰到右括号则取出栈顶元素，判断栈顶元素和右括号是否匹配
4、栈为空或括号不匹配，则为false，否则true
 */
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
