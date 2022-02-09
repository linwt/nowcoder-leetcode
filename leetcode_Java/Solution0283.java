// 移动零


/*
双指针，交换元素：
1、左右指针都从起点开始
2、右指针用于遍历整个数组，遇到零则跳过，遇到非零元素时则与左指针的元素交换，右指针每遍历完一个元素就向右移动一步
3、左指针只有当交换元素后才向右移动一步，保证左指针走过的位置都是非零元素
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}


/*
覆盖元素，后面补0：同样是双指针思路，比直接交换元素多了补0的操作
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
            right++;
        }
        while (left < n) {
            nums[left++] = 0;
        }
    }
}


/*
逻辑同上，用for替代while
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        for (; right < n; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        for (; left < n; left++) {
            nums[left] = 0;
        }
    }
}