package sort;

/*
冒泡排序：
1、第一个for循环表示外循环次数，将所有元素都排序需要的循环次数
  第二个for循环表示内循环次数，将一个元素排序需要的循环次数。一轮循环中从左到右将一个大数交换到后面
2、flag标记一次排序过程是否发生元素位置交换，若没有交换说明已经排序好了，直接结束
 */
public class Bubble {
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Bubble bubble = new Bubble();
        nums = bubble.bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
