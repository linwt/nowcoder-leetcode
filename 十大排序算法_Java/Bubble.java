package sort;

// 冒泡排序
public class Bubble {
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        // 外循环次数
        for (int i = 0; i < n - 1; i++) {
            // 标记一次排序过程是否发生元素位置交换
            boolean flag = true;
            // 内循环次数
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Bubble bubble = new Bubble();
        nums = bubble.bubbleSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
