// 215. 数组中的第K个最大元素
// 主要思路同“347. 前 K 个高频元素”

/*
排序后取倒数第k个元素，api使用快速排序
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


// 具体见“十大排序算法_Java”

/*
快速排序：
1、一次排序操作将返回一个已经排好位置的中点索引mid，该索引左边的元素都小于它，右边的元素都大于等于它
2、找第K个最大元素不用整个数组都排序，将中点索引mid与目标索引target比较，直接返回结果 或 选择递归左或右半部分继续排序
3、递归方法：
  1）方法功能：根据数组、指定左右边界、目标值，进行一次排序，获取排序后的中点索引与目标索引比较，相等则返回目标值
  2）终止条件：左边界等于右边界，说明只剩一个元素，不用排序，直接返回该元素
            由于k在数组长度范围内，目标值一定存在，每次选择有效区间，mid每次加减1，所以不存在左边界大于右边界的情况
  3）递归逻辑：未找到目标值之前，排序好的中点的左半部分或右半部分数组也需要同样的操作寻找目标值，调用同样的方法进行排序，并接收递归方法返回值，最后返回结果
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return mainSort(nums, 0, n - 1, n - k);
    }

    // 递归方法
    private int mainSort(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left];
        }
        int res;
        int mid = partition(nums, left, right);
        if (mid == target) {
            res = nums[target];
        } else if (mid > target) {
            res = mainSort(nums, left, mid - 1, target);
        } else {
            res = mainSort(nums, mid + 1, right, target);
        }
        return res;
    }

    // 一次排序操作
    private int partition(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, left, index - 1);
        return index - 1;
    }

    // 交换元素
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}


/*
最大堆排序：
1、先将普通数组调整成最大堆数组
2、堆顶元素就是最大值，将堆顶元素交换到数组尾部，重新调整剩余数组元素为最大堆
3、循环处理第2步，最终数组升序排序
4、找第K个最大元素不用整个数组都排序，每次调整都会将剩余数组最大值交换到数组尾部，记录交换次数，直到第K个最大元素时直接返回结果
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
        while (n > 0 && k > 0) {
            swap(nums, 0, n - 1);
            n--;
            k--;
            maxHeapify(nums, 0, n);
        }
        return nums[n];
    }

    private void maxHeapify(int[] nums, int root, int n) {
        int maxIndex = root;
        int left = root * 2 + 1, right = root * 2 + 2;
        if (left < n && nums[left] > nums[maxIndex])
            maxIndex = left;
        if (right < n && nums[right] > nums[maxIndex])
            maxIndex = right;
        if (maxIndex != root) {
            swap(nums, maxIndex, root);
            maxHeapify(nums, maxIndex, n);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}