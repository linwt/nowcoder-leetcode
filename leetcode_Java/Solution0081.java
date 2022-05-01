// 81. 搜索旋转排序数组 II


/*
1、二分查找，比“33. 搜索旋转排序数组”多了重复元素
2、二分的本质是「二段性」，并非单调性。只要一段满足某个性质，另外一段不满足某个性质，就可以用「二分」，再利用性质去判断选择收缩区间
3、分类讨论举例
  1）第一类：1011110111 和 1110111101。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 left++ 即可，相当于去掉一个重复的干扰项
  2）第二类：2345671。也就是 nums[left] < nums[mid]，此例子中就是 2 < 5，这种情况下，左半部分有序
    因此如果 nums[left] <= target < nums[mid]，则在左半部分找，否则去右半部分找
  3）第三类：6712345。也就是 nums[left] > nums[mid]，此例子中就是 6 > 2，这种情况下，右半部分有序
    因此如果 nums[mid] < target <= nums[right]，则在右半部分找，否则去前半部分找
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {               // 可能剩下最后一个数，也要判断是否为目标值，所以要等号
            int mid = (left + right) / 2;     // (left + right + 1) / 2 也可以，因为中点值判断过不满足就舍弃，所以不会存在重复中点死循环问题
            if (nums[mid] == target) {        // 判断中点是否为目标值，是则返回true
                return true;
            }
            if (nums[left] == nums[mid]) {    // 由于存在重复元素，左值与中值相等时，无法区分二段性，让左指针右移，去掉一个重复的干扰项
                left++;
                continue;
            }
            if (nums[left] < nums[mid]) {                           // 左半部分有序。等号的情况上面已经判断了，这里就不用等号了
                if (nums[left] <= target && target < nums[mid]) {   // 目标值在左半部分。[left,mid) 因为左值还没判断，中值已经判断过了
                    right = mid - 1;                                // 收缩右区间，中值已经判断过不满足了，不需要包含
                } else {                                            // 目标值在右半部分
                    left = mid + 1;                                 // 收缩左区间，中值已经判断过不满足了，不需要包含
                }
            } else {                                                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {  // 目标值在右半部分。(mid,right] 因为右值还没判断，中值已经判断过了
                    left = mid + 1;                                 // 收缩左区间，中值已经判断过不满足了，不需要包含
                } else {                                            // 目标值在左半部分
                    right = mid - 1;                                // 收缩右区间，中值已经判断过不满足了，不需要包含
                }
            }
        }
        return false;                                               // 没有找到目标值，返回false
    }
}