// 14. 剪绳子


public class Solution {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int x = target % 3;
        int y = target / 3;
        if (x == 1) {
            return (int) Math.pow(3, y - 1) * 2 * 2;
        } else if (x == 2) {
            return (int) Math.pow(3, y) * 2;
        } else {
            return (int) Math.pow(3, y);
        }
    }
}