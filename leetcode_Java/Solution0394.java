// 394. 字符串解码


/*
栈：（这种解法更容易理解）
1、把所有字符入栈，除了']'
2、从栈取出[]内的字符串
3、弹出'['，丢弃
4、从栈获取倍数数字
5、根据倍数把字母入栈
6、把栈里面所有的字母取出来，得到结果
 */
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString();
                stack.pop();
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}


/*
栈：
1、外层的解码需要等待内层解码的结果。先扫描的字符还用不上，但不能忘了它们。我们准备由内到外，层层解决[]，需要保持对字符的记忆，于是用栈。
2、变量含义：
  kStack：存放每一层[]的倍数，遇到'['时入栈暂存，遇到']'时出栈计算当前层解码结果
  resStack：存放上一层[]的子串，遇到'['时入栈暂存，遇到']'时出栈与当前层解码结果拼接
  res：表示当前层[]的子串，最外层没有[]
  k：表示当前层[]的倍数
  temp：表示当前层[]的解码结果
2、入栈时机：遇到'['，意味着要开始解决内层的字符了，外层的数字和子串入栈暂存，并且变量归零用于内层继续计算
  1）当遇到'['，已经扫描的数字就是遇到的[]的“倍数”，入栈暂存
  2）当遇到'['，已经扫描的子串也入栈暂存，括号里的字符解码完后，再一起参与构建字符串
3、出栈时机：遇到']'，内层的字符串扫描完了，数字出栈构建新子串，旧子串出栈与新子串拼接得到最新结果

========== 过程一 =========
s = "abc3[a2[d]]ef"
         ↑
k = 3
res = "abc"
stack = [(3, "abc")]
========== 过程二 =========
s = "abc3[a2[d]]ef"
            ↑
k = 2
res = "a"
stack = [(3, "abc"), (2, "a")]
========== 过程三 =========
s = "abc3[a2[d]]ef"
              ↑
k = 0
res = "d"
curk = 2
oldres = "a"
stack = [(3, "abc")]
temp = curk * res = "dd"
res = oldres + curk * res = "add"
========== 过程四 =========
s = "abc3[a2[d]]ef"
               ↑
k = 0
res = "add"
curk = 3
oldres = "abc"
stack = [(3, "abc")]
temp = curk * res = "addaddadd"
res = oldres + curk * res = "abcaddaddadd"
========== 过程五 =========
s = "abc3[a2[d]]ef"
                 ↑
res = "abcaddaddaddef"
 */
class Solution {
    public String decodeString(String s) {
        Deque<Integer> kStack = new ArrayDeque<>();
        Deque<StringBuilder> resStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                kStack.push(k);
                resStack.push(res);
                k = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int kCur = kStack.pop();
                for (int i = 0; i < kCur; i++) {
                    temp.append(res);
                }
                res = resStack.pop().append(temp);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}