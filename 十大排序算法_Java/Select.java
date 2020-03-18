package sort;

// 选择排序
public class Select {
    public int[] selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min_index])
                    min_index = j;
            }
            int temp = nums[i];
            nums[i] = nums[min_index];
            nums[min_index] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Select select = new Select();
        nums = select.selectSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
