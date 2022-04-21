// 17. 打印从1到最大的n位数


public class Solution {
    public int[] printNumbers (int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = count * 10 + 9;
        }
        int[] nums = new int[count];
        for (int i = 1; i <= count; i++) {
            nums[i - 1] = i;
        }
        return nums;
    }
}