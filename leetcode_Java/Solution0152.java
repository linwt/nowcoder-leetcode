// 152. 乘积最大子数组


/*
1、res记录子数组最大乘积，imax表示以nums[i]结尾的子数组最大乘积，imin表示以nums[i]结尾的子数组最小乘积
2、遍历数据，计算当前最大值，不断更新res
3、由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，当负数出现时则imax与imin进行交换再进行下一步计算
 */
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], imax = 1, imin = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            res = Math.max(res, imax);
        }
        return res;
    }
}


/*
动态规划：
1、dpMax[i]表示以i位置结尾的子数组最大乘积，dpMin[i]表示以i位置结尾的子数组最小乘积
 */
class Solution {
    public int maxProduct(int[] nums) {
        int res;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        res = dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }
}


/*
优化空间，使用变量替代dp数组
 */
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            int imaxOld = imax, iminOld = imin;
            imax = Math.max(nums[i], Math.max(imaxOld * nums[i], iminOld * nums[i]));
            imin = Math.min(nums[i], Math.min(imaxOld * nums[i], iminOld * nums[i]));
            res = Math.max(res, imax);
        }
        return res;
    }
}