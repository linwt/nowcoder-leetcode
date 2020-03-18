package sort;

import java.util.Arrays;

// 归并排序
public class Merge {
    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return nums;
        int mid = n / 2;
        // 递归拆分数组
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, n));
        return combine(left, right);
    }

    // 将两个数组排序合并为一个数组
    private int[] combine(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int i = 0, l = 0, r = 0; i < res.length; i++) {
            if (l >= left.length)
                res[i] = right[r++];
            else if (r >= right.length)
                res[i] = left[l++];
            else if (left[l] > right[r])
                res[i] = right[r++];
            else
                res[i] = left[l++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Merge merge = new Merge();
        nums = merge.mergeSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
