package offer;

import java.math.BigInteger;

// 不用加减乘除做加法
public class Test48 {
    public int Add(int num1, int num2) {
        BigInteger b1 = new BigInteger(String.valueOf(num1));
        BigInteger b2 = new BigInteger(String.valueOf(num2));
        return b1.add(b2).intValue();
    }
}
