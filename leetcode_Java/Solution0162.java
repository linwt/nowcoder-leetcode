// 162. 寻找峰值


/*
二分查找：
1、二分查找的合理性
  1）对于任意数组而言，一定存在峰值，因为 nums[0] = nums[n] = -∞
  2）二分不会错过峰值，因为每次分段查找选择更高的一部分，最终的找到的位置其左右相邻值一定比它低
2、计算中点位置时，(left+right)/2 取整计算，中点位置可能在左边界，一定不可能在右边界，中点位置右边的元素一定存在，所以比较元素时要跟右边元素比较
3、mid 和 mid+1 位置的元素比较，谁大就以谁为新边界。左元素大就继续到左半部分找、右元素大就到右半部分找。

 1  2  3  1
 ↑  ↑     ↑
 l mid    r
============
 1  2  3  1
       ↑  ↑
    l/mid r
============
 1  2  3  1
       ↑
      l/r
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


/*
一次遍历，判断当前位置是否高于左右两边
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
                flag = false;
            }
            if (i + 1 < n && nums[i] < nums[i + 1]) {
                flag = false;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}