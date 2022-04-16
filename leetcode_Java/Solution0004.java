// 4. 寻找两个有序数组的中位数


/*
数组合并，排序，取中间
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Arrays.copyOf(源数组， 复制长度)
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        // System.arraycopy(源数组， 源数组起始索引， 目标数组， 目标数组起始索引， 复制长度)
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);

        if (nums.length % 2 == 0)
            return ((float) nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        else
            return (float) nums[nums.length / 2];
    }
}


/*
逻辑同上
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] nums3 = new int[n];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums3[k] = nums1[i];
            k++;
        }
        for (int j = 0; j < nums2.length; j++) {
            nums3[k] = nums2[j];
            k++;
        }
        Arrays.sort(nums3);
        if (n % 2 == 0) {
            int num1 = nums3[n / 2];
            int num2 = nums3[n / 2 - 1];
            return (num1 + num2) / 2.0;
        } else {
            return nums3[n / 2];
        }
    }
}


/*
双指针：遍历比较两个数组元素，根据奇偶个数找到整体中间位置，计算中位数
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = -1, right = - 1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (index1 < m && (index2 >= n || nums1[index1] < nums2[index2])) {
                right = nums1[index1++];
            } else {
                right = nums2[index2++];
            }
        }
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        }
        return right;
    }
}


/*
二分查找：
1、一个长度为 m 的数组，有 0 到 m 总共 m + 1 个位置可以切。我们把数组 A 和数组 B 分别在 i 和 j 进行切割
2、将 i 的左边和 j 的左边组合成「左半部分」，将 i 的右边和 j 的右边组合成「右半部分」
  1）当 A 数组和 B 数组的总长度是偶数时，如果我们能够保证 左半部分的长度等于右半部分 i+j = m-i + n-j，也就是 j = (m+n)/2 - i，
   且左半部分最大的值小于等于右半部分最小的值，max(A[i-1],B[j-1])) <= min(A[i],B[j]))
   那么 中位数 = (左半部分最大值 + 右半部分最小值) / 2 = (max(A[i-1],B[j-1]) + min(A[i],B[j])) / 2
  2）当 A 数组和 B 数组的总长度是奇数时，如果我们能够保证 左半部分的长度比右半部分大 1， i+j = m-i + n-j + 1，也就是 j = (m+n+1)/2 - i，
   且左半部分最大的值小于等于右半部分最小的值，max(A[i-1],B[j-1])) <= min(A[i],B[j]))
   那么 中位数 = 左半部分最大值 = max(A[i-1],B[j-1])
3、增加 i 的方式用二分，初始化 i 为中间的值，然后减半找中间的，直到找到答案
4、时间复杂度：我们对较短的数组进行了二分查找，所以时间复杂度是 O(log(min(m，n))
  空间复杂度：只有一些固定的变量，和数组长度无关，所以空间复杂度是 O(1)

A:  2  4  6 | 8  10  12  14
   iMin       i             iMax
B:  1  5  8  10  11 | 12  12  15
                       j
=================================
A:  2  4  6  8  10 | 12  14
               iMin   i     iMax
B:  1  5  8 | 10  11  12  12  15
               j
 */
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A);
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}