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
1、题目：给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
2、题目简化：求数组的最大乘积
3、定义dp数组：dpMax[i]表示以i位置结尾的子数组最大乘积，dpMin[i]表示以i位置结尾的子数组最小乘积。由于存在负数，因此要保留当前的最大最小值。
4、初始化：
  1）一维dp数组不用扩容，直接根据dp数组的定义就可以直观地对应进行初始化
  2）dpMax[0] = dpMin[0] = nums[0];
5、状态转移方程：
   dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
   dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
6、遍历dp数组填表：一个for循环遍历dp数组的未知位置，根据状态转移方程直接取dp数组的已知结果计算未知结果
7、返回结果：dpMax[i]中取最大值
 */
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
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