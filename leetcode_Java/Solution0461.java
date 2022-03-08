// 461. 汉明距离


/*
1、异或运算，记为⊕，当且仅当输入位不同时输出为1，故x^y可将x和y二进制位不同的位置标记为1
2、内置位计数功能，计算二进制数中1的个数
 */
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}


/*
n &= n - 1，该运算将 n 的二进制表示的最后一个 1 变成 0，操作几次说明有几个1
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y, count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}


/*
移位实现位计数，每次用最后一位跟1进行与运算，判断是否为1
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, count = 0;
        while (s > 0) {
            count += s & 1;
            s >>= 1;
        }
        return count;
    }
}


/*
1、每次都统计当前 x 和 y 的最后一位，统计完则将 x 和 y 右移一位
2、当 x 和 y 的最高一位 1 都被统计过之后，循环结束
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while ((x | y) != 0) {
            int a = x & 1, b = y & 1;
            count += a ^ b;
            x >>= 1;
            y >>= 1;
        }
        return count;
    }
}