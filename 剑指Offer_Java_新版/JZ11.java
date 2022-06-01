// 11. 旋转数组的最小数字
// 力扣同题“154. 寻找旋转排序数组中的最小值 II”

/*
二分查找
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return array[left];
    }
}


/*
第一处出现降序的位置就是最小值
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return 0;
    }
}