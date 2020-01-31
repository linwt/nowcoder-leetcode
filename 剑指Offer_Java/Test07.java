package offer;

// 斐波那契数列
// 1,1,2,3,5,8,12
public class Test07 {
    // 递推
    public int Fibonacci(int n) {
        int f0 = 0, f1 = 1;
        if (n == 0) {
            return f0;
        }
        if (n == 1) {
            return f1;
        }
        for (int i = 2; i <= n; i++) {
            int temp = f0;
            f0 = f1;
            f1 = temp + f1;
        }
        return f1;
    }

    // 递归
    public int Fibonacci2(int n) {
        int f0 = 0, f1 = 1;
        if (n == 0) {
            return f0;
        }
        if (n == 1) {
            return f1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
