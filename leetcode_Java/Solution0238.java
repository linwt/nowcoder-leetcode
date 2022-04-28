// 238. 除自身以外数组的乘积


/*
前缀和：
1、当前数 = 左边的乘积 x 右边的乘积
2、初始化结果数组为1，方便乘积时保留左右部分的值
3、遍历数组，从左到右计算时，当前位置的值为左部分的乘积；从右到左计算时，当前位置的值为右部分的乘积；
   两次计算都没有将当前位置的值加入乘积，最终当前位置的值就是 左边的乘积 x 右边的乘积

nums   5    2    3    4
res    1    1    1    1
l      1    5   5*2 5*2*3
r   4*3*2  4*3   4    1
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = 1, r = 1, n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
            res[i] *= l;
            l *= nums[i];
            res[n - i - 1] *= r;
            r *= nums[n - i - 1];
        }
        return res;
    }
}