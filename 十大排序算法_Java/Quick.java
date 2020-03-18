package sort;

// 快速排序
public class Quick {
    public int[] quickSort(int[] nums) {
        return mainSort(nums, 0, nums.length - 1);
    }

    private int[] mainSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            // 递归排序左右两部分
            mainSort(nums, left, mid - 1);
            mainSort(nums, mid + 1, right);
        }
        return nums;
    }

    // 一次排序操作
    private int partition(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, left, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Quick quick = new Quick();
        nums = quick.quickSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
