package offer;

// 数值的整数次方
public class Test12 {
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res *= base;
        }
        if (exponent < 0) {
            res = 1 / res;
        }
        return res;
    }
}
