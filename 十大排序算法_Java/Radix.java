package sort;

import java.util.ArrayList;
import java.util.Arrays;

// 基数排序
public class Radix {
    public int[] radixSort(int[] nums) {
        // 创建0-9共10个桶
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bucket.add(new ArrayList<>());
        // 获取最大数字的长度作为排序次数
        int times = String.valueOf(Arrays.stream(nums).max().getAsInt()).length();
        for (int i = 0; i < times; i++) {
            // 从低位到高位，获取数字的基数，并将数字放入对应的桶中
            for (int num : nums)
                bucket.get(num / (int) Math.pow(10, i) % 10).add(num);
            // 有序地将每个桶的数字放回原数组
            int k = 0;
            // 遍历10个桶
            for (int m = 0; m < 10; m++) {
                ArrayList list = bucket.get(m);
                // 遍历桶中所有数字
                for (int n = 0; n < list.size(); n++)
                    nums[k++] = (int) list.get(n);
                // 清空桶
                list.clear();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {10, 244, 6, 212, 38, 528, 7777, 555, 9};
        Radix radix = new Radix();
        nums = radix.radixSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
