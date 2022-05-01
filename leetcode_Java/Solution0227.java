// 227. 基本计算器 II


/*
在“224. 基本计算器”的基础上进阶
1、支持 + - * / ^ % ( ) 的完全表达式问题
2、用map存放运算符的优先级，只有「栈内运算符」比「当前运算符」优先级高或同等，才能进行运算
 */
class Solution {
    Map<Character, Integer> map = new HashMap<>(){{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public int calculate(String s) {
        Deque<Character> opsStack = new ArrayDeque<>();
        Deque<Integer> numsStack = new ArrayDeque<>();
        numsStack.push(0);
        s = s.replaceAll(" ", "");
        int n = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = charArray[i];
            if (c == '(') {
                opsStack.push(c);
            } else if (c == ')') {
                while (!opsStack.isEmpty() && opsStack.peek() != '(') {
                    cal(numsStack, opsStack);
                }
                opsStack.pop();
            } else if (Character.isDigit(c)) {
                int j = i, num = 0;
                while (j < n && Character.isDigit(charArray[j])) {
                    num = num * 10 + charArray[j++] - '0';
                }
                numsStack.push(num);
                i = j - 1;
            } else {
                if (i > 0 && charArray[i - 1] == '(') {
                    numsStack.push(0);
                }
                while (!opsStack.isEmpty() && opsStack.peek() != '(' && map.get(opsStack.peek()) >= map.get(c)) {
                    cal(numsStack, opsStack);
                }
                opsStack.push(c);
            }
        }
        while (!opsStack.isEmpty()) {
            cal(numsStack, opsStack);
        }
        return numsStack.peek();
    }

    private void cal(Deque<Integer> numsStack, Deque<Character> opsStack) {
        if (numsStack.isEmpty() || numsStack.size() < 2 || opsStack.isEmpty()) {
            return;
        }
        int b = numsStack.pop(), a = numsStack.pop();
        char op = opsStack.pop();
        int res = 0;
        if (op == '+') {
            res = a + b;
        } else if (op == '-') {
            res = a - b;
        } else if (op == '*') {
            res = a * b;
        } else if (op == '/') {
            res = a / b;
        } else if (op == '%') {
            res = a % b;
        } else if (op == '^') {
            res = (int) Math.pow(a, b);
        }
        numsStack.push(res);
    }
}