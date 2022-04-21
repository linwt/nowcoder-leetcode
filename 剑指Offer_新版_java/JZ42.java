// 42. 连续子数组的最大和


public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxNum = Arrays.stream(array).max().getAsInt();
        if (maxNum < 0) {
            return maxNum;
        }
        int maxSum = 0, curSum = 0;
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
