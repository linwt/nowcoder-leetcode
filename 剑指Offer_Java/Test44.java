package offer;

// 翻转单词顺序列
public class Test44 {
    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().equals("")) {
            return str;
        }
        String[] array = str.split(" ");
        String res = "";
        for (int i = array.length - 1; i >= 0; i--) {
            res = res + array[i] + " ";
        }
        return res.trim();
    }
}
