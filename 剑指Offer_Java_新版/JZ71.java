// 71. 变态跳台阶


// f(1)=1  f(2)=2  f(3)=4  f(4)=8
// f(n)=2的n-1次方
public class Solution {
    public int JumpFloorII(int target) {
        int res = 1;
        for (int i = 1; i < target; i++) {
            res *= 2;
        }
        return res;
    }
}
