package sort;

import java.util.Arrays;

/*
桶排序：
1、获取数组最大值、最小值，以数值范围定义桶数组stats大小，数组默认值为0
2、以数值个数定义结果数组res大小，数组默认值为0
3、遍历元素，映射到桶中，统计每个数的出现次数
4、遍历每个桶，按序获取数字放到结果数组
 */
public class Bucket {
    public int[] bucketSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int[] stats = new int[max - min + 1];
        int[] res = new int[nums.length];
        for(int num : nums) {
            stats[num - min]++;
        }
        int k = 0;
        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats[i]; j++) {
                res[k++] = min + i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Bucket bucket = new Bucket();
        nums = bucket.bucketSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
