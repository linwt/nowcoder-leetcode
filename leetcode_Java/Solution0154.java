// 154. 寻找旋转排序数组中的最小值 II
// 剑指offer同题“11. 旋转数组的最小数字”

/*
1、二分查找，比“153. 寻找旋转排序数组中的最小值”多了重复元素
2、当中值等于右值时，无法区分二段性，让右指针左移，去掉一个干扰项

7  0  1  1  1  1  1  2  3  4
↑           ↑              ↑
l           m              r
=============================
7  0  1  1  1  1  1  2  3  4
↑     ↑     ↑
l     m     r
=============================
7  0  1  1  1  1  1  2  3  4
↑  ↑     ↑
l  m     r
=============================
7   0  1  1  1  1  1  2  3  4
↑   ↑
l/m r
=============================
7  0  1  1  1  1  1  2  3  4
   ↑
  l/r
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}