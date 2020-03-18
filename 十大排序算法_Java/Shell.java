package sort;

// 希尔排序
public class Shell {
    public int[] shellSort(int[] nums) {
        int n = nums.length;
        int gap = n / 2;
        // 分组插入排序
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (nums[j] > nums[j + gap]) {
                        int temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
                }
            }
            gap /= 2;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Shell shell = new Shell();
        nums = shell.shellSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
