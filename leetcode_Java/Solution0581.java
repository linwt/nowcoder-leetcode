// 581. 最短无序连续子数组


/*
排序：拷贝数组并排序，从左右到中间，比较两个数组元素不同的位置，得到无序子数组的左右边界，左右边界差值即为最短无序连续子数组的长度
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int n = nums.length;
        int[] newNums = Arrays.copyOf(nums, n);
        Arrays.sort(newNums);
        int left = 0, right = n - 1;
        while (nums[left] == newNums[left]) {
            left++;
        }
        while (nums[right] == newNums[right]) {
            right--;
        }
        return right - left + 1;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}


/*
1、假设把数组分成三段，左段和右段是标准的升序数组，中段数组虽是无序的，但满足最小值大于等于左段的最大值，最大值小于等于右段的最小值
2、需要找到中段的左右边界
  1）从左到右遍历，动态维护当前最大值max，那么最后一个小于max的元素位置就是右边界（如果大于等于max就会归于右段）
  2）从右到左遍历，动态维护当前最小值min，那么最后一个大于min的元素位置就是左边界（如果小于等于min就会归于左段）
3、左右边界差值就是最短无序连续子数组的长度

     左段                     中段                    右段
1   2   3   4        6   4   7   5   7   4        7   8   9
                     ↑   ↑           ↑   ↑
                  begin min         max end
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = nums[n - 1], max = nums[0];
        int begin = 0, end = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[n - i - 1] > min) {
                begin = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return end - begin + 1;
    }
}