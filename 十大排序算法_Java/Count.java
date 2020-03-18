package sort;

import java.util.Arrays;

// 计数排序
public class Count {
    public int[] countSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int[] stats = new int[max - min + 1];
        Arrays.fill(stats, 0);
        int[] res = new int[nums.length];
        Arrays.fill(res, 0);

        for (int num : nums)
            stats[num - min]++;
        // 记录每个数字存放的索引位置
        for (int i = 1; i < nums.length; i++)
            stats[i] += stats[i - 1];
        // 获取每个数字的最终索引并存入结果数组
        for (int num : nums) {
            res[stats[num - min] - 1] = num;
            stats[num - min]--;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Count count = new Count();
        nums = count.countSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
