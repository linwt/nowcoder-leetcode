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


/*
牛顿迭代：从大到小逼近
1、求根号x的近似值res，先令 res 为 x，即从一个大数开始迭代逼近，不断令 res 等于 (res+x/res)/2，由于是向下取整，当 res * res <= x时，此时res为最终结果值
2、res要用long类型，计算过程如果为整型会溢出，最后结果再强转为整型即可

  x = 5
res = 5 → 3 → 2
 */
class Solution {
    public int mySqrt(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}


/*
暴力：从小到大逼近
1、从1开始，平方值小于等于x，则继续查找，直到第一个平方值大于x结束循环，返回前一个值
2、平方值可能会溢出，要转为long类型
 */
class Solution {
    public int mySqrt(int x) {
        long res = 1;
        while (res * res <= x) {
            res++;
        }
        return (int) res - 1;
    }
}


/*
库函数
 */
class Solution {
    public int mySqrt(int x) {
        return (int) Math.pow(x, 0.5);
    }
}