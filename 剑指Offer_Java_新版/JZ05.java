// 5. 替换空格


/*
增删、构造、替换
 */
public class Solution {
    // 通过删增来替换字符串
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "%20");
            }
        }
        return str.toString();
    }

    // 构造新字符串
    public String replaceSpace2(StringBuffer str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == ' ') {
                res += "%20";
            } else {
                res += s;
            }
        }
        return res;
    }

    // 调用替换字符串方法
    public String replaceSpace3(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }
}