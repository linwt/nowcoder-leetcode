// 153. 寻找旋转排序数组中的最小值


/*
二分查找：二分寻找最小值索引
--------------------------------------------------------------------
递增序列：
        *
      *
    *
  *
*
==============
旋转序列：
  1）旋转后的左段最小值大于右段最大值
  2）中点在断崖左段时 nums[mid] > nums[right]，最小值在右半部分
  3）中点在断崖右段时 nums[mid] < nums[right]，最小值在左半部分
  *
*
        *
      *
    *
---------------------------------------------------------------------
例一： 1  2  3  4  5
        右排序数组
例二： 3  4  5  |  1  2
      左排序数组   右排序数组

1、寻找旋转数组的最小元素即为寻找 右排序数组 的首个元素 nums[x]，称 x 为 旋转点
2、左排序数组任一元素 >= 右排序数组任一元素
3、中值跟右值比较，而不跟左值比较的原因是，右值一定在右排序数组，左值不一定在左排序数组，所以跟左值比较时不能确定中值在哪个排序数组，从而无法确定缩小区间范围
  如例一左值在右排序数组，例二左值在左排序数组
---------------------------------------------------------------------
3  4  5  1  2
↑     ↑     ↑
l    mid    r
==============
3  4  5  1  2
         ↑  ↑
      l/mid r
==============
3  4  5  1  2
         ↑
        l/r
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;   // 左闭右闭区间，如果用右开区间则不方便判断右值
        while (left < right) {                   // 循环不变式，如果left == right，则循环结束
            int mid = (left + right) / 2;        // 向下取整，mid更靠近left，即 left <= mid < right，mid右边的元素必然存在，所以要跟右值比较
            if (nums[mid] < nums[right]) {       // 中值小于右值，则右半部分必然递增，最小值在左半部分，收缩右边界
                right = mid;                     // 由于中值是小值，所以也可能是最小值，右边界要包括中值
            } else {
                left = mid + 1;                  // 中值大于右值，最小值在右半部分，由于中值是大值，所以左边界不用包括中值
            }
        }
        return nums[left];                       // 循环结束，left == right，返回最小值
    }
}


/*
二分查找：二分寻找最大值索引，下一位就是最小值，索引加1对数组长度取余 即为最小值索引

3  4  5  1  2
↑     ↑     ↑
l    mid    r
==============
3  4  5  1  2
      ↑  ↑  ↑
      l mid r
==============
3  4  5  1  2
      ↑
     l/r
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;            // 左闭右闭区间，如果用左开区间则不方便判断左值
        while (left < right) {                  // 循环不变式，如果left == right，则循环结束
            int mid = (left + right + 1) / 2;   // 先加1再向下取整，mid更靠近right，即 left < mid <= right，mid左边的元素必然存在，所以要跟左值比较
            if (nums[left] < nums[mid]) {       // 左值小于中值，则左半部分必然递增，最大值在左半部分，收缩左边界
                left = mid;                     // 由于中值是大值，所以也可能是最大值，左边界要包括中值
            } else {
                right = mid - 1;                // 左值大于中值，最大值在左半部分，由于中值是小值，所以右边界不用包括中值
            }
        }
        return nums[(left + 1) % n];            // 最大值下一位就是最小值
    }
}


/*
一次遍历，当前元素小于前一元素时，该元素时最小值
 */
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}