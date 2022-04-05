// 33. 搜索旋转排序数组


/*
直接遍历查找，时间复杂度O(n)
 */
class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}


/*
二分查找：时间复杂度O(logn)
1、左右索引求和除以2，得到中点索引，如果中点索引对应值为目标值，则返回中点索引
2、在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid-1] 和 [mid+1, r] 哪个部分是有序的，并判断 target 是否在有序的部分，从而决定改变二分查找的上下界
  如果 [l, mid-1] 是有序数组，且 target 的大小满足 nums[left] <= target < nums[mid] ，则到 [l, mid-1]寻找，否则在 [mid+1, r] 寻找
  如果 [mid+1, r] 是有序数组，且 target 的大小满足 nums[mid] < target <= nums[right]，则到 [mid+1, r]寻找，否则在 [l, mid-1] 寻找
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = n - 1;
        // 可能最后只剩下一个数要判断，所以需要等号
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 当剩下两个数时，left=mid，由于上面nums[mid]=nums[left]已经校验过不等于target，所以当前数要舍弃，期望左指针右移，所以需要等号，使if条件成立进入里面的逻辑
            if (nums[left] <= nums[mid]) {  // 左半部分有序
                // nums[left]还没判断过，所以需要等号。上面nums[mid]单独判断过了，所以不用等号。
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {    // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}