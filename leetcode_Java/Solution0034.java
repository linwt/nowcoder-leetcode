// 34. 在排序数组中查找元素的第一个和最后一个位置


/*
二分查找：
1、二分查找，找到中点位置的值，比较判断是否为目标值
2、若不是目标值，则缩小一半的查找区间
3、若是目标值，则向两边扩散查找左右边界
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] != target) {
                        break;
                    }
                    res[0] = i;
                }
                for (int i = mid; i < n; i++) {
                    if (nums[i] != target) {
                        break;
                    }
                    res[1] = i;
                }
                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        Arrays.fill(res, -1);
        return res;
    }
}