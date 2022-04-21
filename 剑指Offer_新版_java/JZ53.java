// 53. 数字在排序数组中出现的次数


public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                for (int j = i; j < array.length; j++) {
                    if (array[j] == k) {
                        count++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return count;
    }
}
