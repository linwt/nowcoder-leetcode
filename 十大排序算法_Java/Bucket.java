package sort;

import java.util.Arrays;

// 桶排序
public class Bucket {
    public int[] bucketSort(int[] nums) {
        // 获取数组最大值、最小值
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        // 以数值范围定义数组大小
        int[] stats = new int[max - min + 1];
        Arrays.fill(stats, 0);
        // 以数值个数定义的数组大小
        int[] res = new int[nums.length];
        Arrays.fill(res, 0);

        // 统计每个数的出现次数
        for(int num : nums)
            stats[num - min]++;
        // 遍历每个桶，按序获取数字放到结果数组
        int k = 0;
        for (int i = 0; i < stats.length; i++)
            for (int j = 0; j < stats[i]; j++)
                res[k++] = min + i;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Bucket bucket = new Bucket();
        nums = bucket.bucketSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
