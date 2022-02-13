// 区域和检索 - 数组不可变


/*
暴力破解：直接累加计算区间和，时间复杂度O(n)
 */
class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }
}


/*
前缀和：
1、使用数组存放前缀和，preSum[n] 表示nums数组索引区间 [0, n-1] 的和
2、计算某个区间元素和，可以直接通过前缀和相减得到，时间复杂度O(1)
 */
class NumArray {
    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */