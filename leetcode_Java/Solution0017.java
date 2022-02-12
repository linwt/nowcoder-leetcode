// 电话号码的字母组合

/*
回溯
 */
class Solution {
    private Map<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private List<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int digitIndex) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letter = map.get(digits.charAt(digitIndex));
        for (int letterIndex = 0; letterIndex < letter.length(); letterIndex++) {
            sb.append(letter.charAt(letterIndex));
            backtrack(digits, digitIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


/*
广度优先：利用队列存放字母组合，当队列不为空且数字未遍历完，则将队列的所有字母组合拿出来，每个字母组合都拼接上数字对应的字母，然后放回队列
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        int digitIndex = 0;
        while (!queue.isEmpty() && digitIndex < digits.length()) {
            int curSize = queue.size();
            while (curSize > 0) {
                String str = queue.poll();
                String letter = map.get(digits.charAt(digitIndex));
                for (int letterIndex = 0; letterIndex < letter.length(); letterIndex++) {
                    queue.add(str + letter.charAt(letterIndex));
                }
                curSize--;
            }
            index++;
        }
        return new ArrayList<>(queue);
    }
}


/*
逻辑同上，使用for替代while
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for (int digitIndex = 0; !queue.isEmpty() && digitIndex < digits.length(); digitIndex++) {
            for (int curSize = queue.size(); curSize > 0; curSize--) {
                String str = queue.poll();
                String letter = map.get(digits.charAt(digitIndex));
                for (int letterIndex = 0; letterIndex < letter.length(); letterIndex++) {
                    queue.add(str + letter.charAt(letterIndex));
                }
            }
        }
        return new ArrayList<>(queue);
    }
}