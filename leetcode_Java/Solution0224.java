// 224. 基本计算器


/*
双栈：
1、使用两个栈，numsStack 存放数字，opsStack 存放操作符
2、预处理：
  1）由于第一个数可能是负数，为了减少边界判断，先往 numsStack 添加一个 0
  2）输入中不存在两个连续的操作符，为防止 () 内出现的首个字符为运算符，将所有空格去掉，将 (- 替换为 (0- ，(+ 替换为 (0+
3、遍历字符串中的字符
  1）遇到 ( 时，则存入操作符栈
  2）遇到 ) 时，
    ① 当操作符栈 不为空 且 栈顶不是左括号时，取出两个数字和操作符进行计算，并将计算结果存入数字栈
    ② 直到遇到左括号，从操作符栈 出栈
  3）遇到数字时，继续遍历获取连续的数字，并将字符串转化成整型类型数字，最后数字存入数字栈
  4）遇到操作符 +、- 时，
    ① 如果前一字符是左括号，要先将0存入数字栈，表示 (0- 或 (0+ ，才能进行计算
    ② 当操作符栈 不为空 且 栈顶不是左括号时，取出两个数字和操作符进行计算，并将计算结果存入数字栈
    ③ 将当前操作符存入 操作符栈
4、操作符栈仍不为空时，取出两个数字和操作符进行计算，并将计算结果存入数字栈，最终返回数字栈顶值
5、计算的时机：
  1）当前字符为 ) ，操作符栈顶字符为 (，说明括号内的数字计算完了，可以结束了
     当前字符为 +、- ，操作符栈顶字符为 (，说明括号内的数字只有一个，还不能计算
     所以遇到 )、+、- 时，操作符栈 不为空 且 栈顶不是 ( 时才能计算
  2）遇到 )、+、- 时，才会计算前一操作符的结果，然后将 (出操作符栈 或 +、-入操作符栈
  3）字符串遍历完后，操作符栈会不为空，因为 遇到新的操作符才会计算旧的操作符 和 受到(的限制 导致前面的没有计算，但只剩 +、-，所以可以直接计算
 */
class Solution {
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
                while (!opsStack.isEmpty() && opsStack.peek() != '(') {
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
        numsStack.push(op == '+' ? a + b : a - b);
    }
}


/*
ArrayDeque使用不同的api
 */
class Solution {
    public int calculate(String s) {
        Deque<Character> opsQueue = new ArrayDeque<>();
        Deque<Integer> numsQueue = new ArrayDeque<>();
        numsQueue.addLast(0);
        s = s.replaceAll(" ", "");
        int n = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = charArray[i];
            if (c == '(') {
                opsQueue.addLast(c);
            } else if (c == ')') {
                while (!opsQueue.isEmpty() && opsQueue.peekLast() != '(') {
                    cal(numsQueue, opsQueue);
                }
                opsQueue.pollLast();
            } else if (Character.isDigit(c)) {
                int j = i, num = 0;
                while (j < n && Character.isDigit(charArray[j])) {
                    num = num * 10 + charArray[j++] - '0';
                }
                numsQueue.addLast(num);
                i = j - 1;
            } else {
                if (i > 0 && charArray[i - 1] == '(') {
                    numsQueue.addLast(0);
                }
                while (!opsQueue.isEmpty() && opsQueue.peekLast() != '(') {
                    cal(numsQueue, opsQueue);
                }
                opsQueue.addLast(c);
            }
        }
        while (!opsQueue.isEmpty()) {
            cal(numsQueue, opsQueue);
        }
        return numsQueue.peekLast();
    }

    private void cal(Deque<Integer> numsQueue, Deque<Character> opsQueue) {
        if (numsQueue.isEmpty() || numsQueue.size() < 2 || opsQueue.isEmpty()) {
            return;
        }
        int b = numsQueue.pollLast(), a = numsQueue.pollLast();
        char op = opsQueue.pollLast();
        numsQueue.addLast(op == '+' ? a + b : a - b);
    }
}