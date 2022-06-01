// 81. 调整数组顺序使奇数位于偶数前面(二)


/*
双指针：左右指针从两边向中间遍历，交换奇偶数位置
 */
public class Solution {
    public int[] reOrderArrayTwo (int[] array) {
        int n = array.length;
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < n && array[left] % 2 != 0) {
                left++;
            }
            while (right >= 0 && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        return array;
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}