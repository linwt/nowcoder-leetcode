package HOT100;


// 汉明距离
public class Solution461 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int res = 0;
        while (num != 0) {
            res += num & 1;
            num >>= 1;
        }
        return res;
    }
}
