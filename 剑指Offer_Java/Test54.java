package offer;

// 字符流中第一个不重复的字符
public class Test54 {
    int[] array = new int[256];
    StringBuilder sb = new StringBuilder();

    public void Insert(char ch) {
        array[ch]++;
        sb.append(ch);
    }

    public char FirstAppearingOnce() {
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            if (array[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '#';
    }
}
