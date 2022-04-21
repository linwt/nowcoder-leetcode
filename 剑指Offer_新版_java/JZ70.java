// 70. 矩形覆盖


// 类似斐波那契数列：f(1)=1  f(2)=2  f(3)=3  f(4)=5
public class Solution {
    public int RectCover(int target) {
        int a = 0, b = 1;
        if (target == 0)
            return 0;
        for (int i = 0; i < target; i++) {
            int temp = a;
            a = b;
            b += temp;
        }
        return b;
    }
}
