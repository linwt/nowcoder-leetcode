package HOT100;

import java.util.*;

// 电话号码的字母组合
public class Solution017 {
    List<String> list = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            combine("", digits);
        return list;
    }

    private void combine(String res, String digits) {
        if (digits.length() == 0) {
            list.add(res);
        } else {
            String str = map.get(digits.charAt(0) + "");
            for (int i = 0; i < str.length(); i++) {
                combine(res + str.charAt(i), digits.substring(1));
            }
        }
    }

}
