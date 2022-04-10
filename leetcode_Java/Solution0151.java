// 151. 颠倒字符串中的单词


/*
1、字符串去掉头尾空格，按空格分隔字符串，倒序拼接单词
2、拼接单词字符串可以使用StringBuilder直接构造，也可以先把单词加到列表最后拼接
 */
class Solution {
    public String reverseWords(String s) {
        String[] splits = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            String word = splits[i];
            if (word == "") {
                continue;
            }
            res.append(word);
            if (i > 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}


/*
去掉头尾空格，正则表达式\\s+ 连续空白字符作为分隔符，得到单词列表，列表反转，再通过空格字符连接成字符串
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}


/*
双指针：从右到左，跳过空格，遍历得到一个单词的索引区间，将单词加入列表，最后列表通过空格字符连接成字符串
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        int left = n - 1, right = n - 1;
        List<String> list = new ArrayList<>();
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            list.add(s.substring(left + 1, right + 1));
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return String.join(" ", list);
    }
}


/*
双端队列：从左到右，遍历字符构造出一个单词，遇到空格时且单词不为空就将单词加到队列头部，最后队列通过空格字符连接成字符串
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s += " ";
        int n = s.length();
        int left = 0, right = n - 1;
        Deque<String> queue = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() != 0 && c == ' ') {
                queue.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(s.charAt(left));
            }
            left++;
        }
        return String.join(" ", queue);
    }
}