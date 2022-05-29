package sort;

/*
希尔排序：分组插入排序
1、第一个for循环表示每组间隔，间隔越小则分组内元素越多，不断减小间隔，循环直到间隔为1，整体归为一组
2、第二个和第三个for循环表示对每个分组进行插入排序
  第二个for循环从左到右遍历要排序的元素，元素分别属于不同的分组
  第三个for循环从右到左将要排序的元素进行交换排序，通过gap获取对应分组内的元素进行交换
3、i从gap开始，j从i开始，条件j>=gap保证j-gap不会越界
4、元素比较结果不用交换时，左边元素已经排序，可结束本轮排序
 */
public class Shell {
    public int[] shellSort(int[] nums) {
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (nums[j] < nums[j - gap]) {
                        int temp = nums[j];
                        nums[j] = nums[j - gap];
                        nums[j - gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Shell shell = new Shell();
        nums = shell.shellSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
