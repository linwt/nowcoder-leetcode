package offer;

// 跳台阶
// f(1)=1  f(2)=2  f(3)=3  f(4)=5  f(5)=8
public class Test08 {
    public int JumpFloor(int target) {
        int a = 1, b = 1;
        for (int i = 0; i < target; i++) {
            int temp = a;
            a = b;
            b += temp;
        }
        return a;
    }
}
