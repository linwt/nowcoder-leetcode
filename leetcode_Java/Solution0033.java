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
简单题“704.二分查找”
二分查找：时间复杂度O(logn)
1、左右索引求和除以2，得到中点索引，如果中点索引对应值为目标值，则返回中点索引
2、在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid-1] 和 [mid+1, r] 哪个部分是有序的，并判断 target 是否在有序的部分，从而决定改变二分查找的上下界
  如果 nums[left] < nums[mid]，那么左半部分 [l, mid-1] 是有序数组。如果 target 的大小满足 nums[left] <= target < nums[mid] ，则到 [l, mid-1]寻找，否则在 [mid+1, r] 寻找
  如果 nums[left] > nums[mid]，那么右半部分 [mid+1, r] 是有序数组。如果 target 的大小满足 nums[mid] < target <= nums[right]，则到 [mid+1, r]寻找，否则在 [l, mid-1] 寻找
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
        while (left <= right) {                 // 可能最后只剩下一个数要判断，所以需要等号
            int mid = (left + right) / 2;       // (left + right + 1) / 2 也可以，因为中值判断过不满足就舍弃，所以不会存在重复中点死循环问题
            if (nums[mid] == target) {          // 判断中点是否为目标值，是则返回中点
                return mid;
            }
            // 当剩下两个数时，中点落在左边，由于上面已经校验过中值不等于目标值，所以当前数要舍弃，期望左指针右移，所以需要等号，使if条件成立进入里面的逻辑，让左指针右移
            if (nums[left] <= nums[mid]) {                              // 左半部分有序
                if (nums[left] <= target && target < nums[mid]) {       // 目标值在左半部分。[left,mid) 因为左值还没判断，中值已经判断过了
                    right = mid - 1;                                    // 收缩右区间，中值已经判断过不满足了，不需要包含
                } else {                                                // 目标值在右半部分
                    left = mid + 1;                                     // 收缩左区间，中值已经判断过不满足了，不需要包含
                }
            } else {                                                    // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {      // 目标值在右半部分。(mid,right] 因为右值还没判断，中值已经判断过了
                    left = mid + 1;                                     // 收缩左区间，中值已经判断过不满足了，不需要包含
                } else {                                                // 目标值在左半部分
                    right = mid - 1;                                    // 收缩右区间，中值已经判断过不满足了，不需要包含
                }
            }
        }
        return -1;                                                      // 找不到返回-1
    }
}