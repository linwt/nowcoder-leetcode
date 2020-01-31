package offer;

// 把字符串转换成整数
public class Test49 {
    public int StrToInt(String str) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return 0;
        }
    }
}
