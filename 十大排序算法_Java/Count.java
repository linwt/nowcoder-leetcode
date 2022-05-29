package sort;

import java.util.Arrays;

/*
计数排序：
1、获取数组最大值、最小值，以数值范围定义桶数组stats大小，数组默认值为0
2、以数值个数定义结果数组res大小，数组默认值为0
3、遍历元素，映射到桶中，统计每个数的出现次数
4、遍历桶，滚动累加，此时桶值表示包括当前元素 前面总共有多少个元素，即表示元素在结果数组中的索引位置
5、遍历元素，映射到桶中获取元素的最终索引，将元素存入结果数组。桶中该元素的索引位置减1，表示下一个同样的元素存放的位置
 */
public class Count {
    public int[] countSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int[] stats = new int[max - min + 1];
        int[] res = new int[nums.length];
        for (int num : nums) {
            stats[num - min]++;
        }
        for (int i = 1; i < stats.length; i++) {
            stats[i] += stats[i - 1];
        }
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
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
