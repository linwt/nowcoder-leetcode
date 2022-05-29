package sort;

/*
插入排序：
1、第一个for循环从左到右遍历要排序的元素，第二个for循环从右到左将要排序的元素进行交换排序
2、i从1开始，j从i开始，条件j>0保证j-1不会越界
2、元素比较结果不用交换时，左边元素已经排序，可结束本轮排序
 */
public class Insert {
    public int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Insert insert = new Insert();
        nums = insert.insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
