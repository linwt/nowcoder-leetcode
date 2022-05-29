package sort;

import java.util.ArrayList;
import java.util.Arrays;

/*
基数排序：
1、创建0-9共10个桶
2、获取最大数字的长度作为排序次数
3、遍历数字，每个数字从低位到高位，获取数字的基数，由基数获取对应的桶，并将数字放入对应的桶中
4、遍历10个桶，有序地将每个桶的数字放回原数组，然后清空桶，准备下一轮排序
5、在低位有序的前提下，对高位排序，最终得到整体排序数组
 */
public class Radix {
    public int[] radixSort(int[] nums) {
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        int times = String.valueOf(Arrays.stream(nums).max().getAsInt()).length();
        for (int i = 0; i < times; i++) {
            for (int num : nums) {
                buckets.get(num / (int) Math.pow(10, i) % 10).add(num);
            }
            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer num : bucket) {
                    nums[index++] = num;
                }
                bucket.clear();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {10, 244, 6, 212, 38, 528, 7777, 555, 9};
        Radix radix = new Radix();
        nums = radix.radixSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
