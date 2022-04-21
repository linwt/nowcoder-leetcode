// 39.数组中出现次数超过一半的数字


public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(array);
        int count = 0;
        int num = array[len / 2];
        for (int i = 0; i < len; i++) {
            if (array[i] == num) {
                count++;
            }
        }
        if (count > len / 2) {
            return num;
        }
        return 0;
    }
}
