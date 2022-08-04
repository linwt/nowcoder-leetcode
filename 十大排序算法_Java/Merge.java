package sort;

import java.util.Arrays;

/*
归并排序：递归
1、方法功能：入参是一个数组，返回排序后的数组
2、终止条件：数组长度小于2时，返回该数组
3、一个元素处理过程和返回结果：直接返回该数组
4、递归调用：左半部分和右半部分数组同样需要排序，因此调用同样的方法
5、递归顺序：当前数组排序 需要依赖 左半部分和右半部分数组，因此要先递归排序左半部分和右半部分数组
6、使用递归调用结果和返回结果：将两个有序数组合并，返回最终的排序数组
 */
public class Merge {
    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int mid = n / 2;
        // 递归拆分数组
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, n));
        return combine(left, right);
    }

    // 将两个有序数组合并为一个排序数组
    private int[] combine(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int i = 0, l = 0, r = 0; i < res.length; i++) {
            if (l >= left.length) {
                res[i] = right[r++];
            } else if (r >= right.length) {
                res[i] = left[l++];
            } else if (left[l] < right[r]) {
                res[i] = left[l++];
            } else {
                res[i] = right[r++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Merge merge = new Merge();
        nums = merge.mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
