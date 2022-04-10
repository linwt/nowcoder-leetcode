// 69. x 的平方根


/*
二分查找：
1、while条件left<=right，等号要加上，包含了x=0的情况时left==right
2、每次找到中点，比较 中点的平方 与 x 的大小，决定区间缩小的方向
3、返回值小数会被省去，中点 可能刚好是目标值 或 可能就是最后一个平方小于x的值，所以每次都要保存中点防止丢失
4、中点的平方可能数值较大，超过int范围导致溢出，所以需要先强转为long类型再计算，比较大小时x自动从int类型向上转型为long类型
 */
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}


class Solution {
    public int mySqrt(int x) {
        return (int) Math.pow(x, 0.5);
    }
}