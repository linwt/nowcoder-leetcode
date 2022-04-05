// 88. 合并两个有序数组


/*
直接合并后排序
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}


/*
双指针：创建新的数组空间，两个数组从左到右遍历比较出 较小的元素，从数组前面开始存储。不能在原数组存储，因为元素可能取出前被覆盖
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int p1 = 0, p2 = 0, index = 0;
        int num;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                num = nums2[p2++];
            } else if (p2 == n) {
                num = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                num = nums1[p1++];
            } else {
                num = nums2[p2++];
            }
            nums[index++] = num;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums[i];
        }
    }
}


/*
逆向双指针：数组后半部分是空的，两个数组从右到左遍历比较出 较大的元素，从数组后面开始存储
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, index = m + n - 1;
        int num;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                num = nums2[p2--];
            } else if (p2 == -1) {
                num = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                num = nums1[p1--];
            } else {
                num = nums2[p2--];
            }
            nums1[index--] = num;
        }
    }
}