package HOT100;

import java.util.Arrays;

// 寻找两个有序数组的中位数
public class Solution004 {
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
