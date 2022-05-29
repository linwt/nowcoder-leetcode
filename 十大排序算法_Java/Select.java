package sort;

/*
选择排序：第一个for循环遍历待排序位置，从左到右依次排序。第二个for循环从左到右遍历查找最小元素的索引，然后与待排序位置交换
 */
public class Select {
    public int[] selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Select select = new Select();
        nums = select.selectSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
