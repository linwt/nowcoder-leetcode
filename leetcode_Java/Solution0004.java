// 寻找两个有序数组的中位数


/*
数组合并，排序，取中间
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Arrays.copyOf(源数组， 复制长度)
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        // System.arraycopy(源数组， 源数组起始索引， 目标数组， 目标数组起始索引， 复制长度)
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);

        if (nums.length % 2 == 0)
            return ((float) nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        else
            return (float) nums[nums.length / 2];
    }
}


/*
逻辑同上
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums3 = new int[n];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums3[k] = nums1[i];
            k++;
        }
        for (int j = 0; j < nums2.length; j++) {
            nums3[k] = nums2[j];
            k++;
        }
        Arrays.sort(nums3);
        if (n % 2 == 0) {
            int num1 = nums3[n / 2];
            int num2 = nums3[n / 2 - 1];
            return (num1 + num2) / 2.0;
        } else {
            return nums3[n / 2];
        }
    }
}