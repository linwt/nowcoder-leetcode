package sort;

/*
快速排序：
1、一次排序操作将返回一个已经排好位置的中点索引mid，该索引左边的元素都小于它，右边的元素都大于等于它
2、递归方法：
  1）方法功能：根据数组和指定左右边界，进行一次排序，然后返回排序后的数组
  2）终止条件：左边界大于等于右边界，说明只剩一个元素或边界无效，不用排序，直接返回数组
  3）递归逻辑：排序好的中点的左半部分和右半部分数组也需要同样的操作，调用同样的方法进行排序。数组是引用类型，不用接收递归方法返回值，最后直接返回数组即可
 */

/*
一次排序初始：
  3     2     3     1     2     4     5     5     6
  ↑     ↑                                         ↑
 left index/i                                   right
============================================================
一次排序遍历交换过程：
  3     2     3     1     2     4     5     5     6
  ↑           ↑     ↑                             ↑
 left       index   i                           right
============================================================
一次排序遍历结束，准备交换中点，index-1表示最后一个值小于left的索引：
  3     2     1     2     3     4     5     5     6
  ↑                 ↑     ↑                       ↑     ↑
 left            index-1 index                   right  i
============================================================
一次排序结果：
  2     2     1     3     3     4     5     5     6
                    ↑
                   mid
============================================================
下一次排序：
  2     2     1     3     3     4     5     5     6
  ↑           ↑     ↑     ↑                       ↑
 left       mid-1  mid  mid+1                   right
 */
public class Quick {
    public int[] quickSort(int[] nums) {
        return mainSort(nums, 0, nums.length - 1);
    }

    // 递归方法
    private int[] mainSort(int[] nums, int left, int right) {
        if (left >= right) {
            return nums;
        }
        int mid = partition(nums, left, right);
        mainSort(nums, left, mid - 1);
        mainSort(nums, mid + 1, right);
        return nums;
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

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Quick quick = new Quick();
        nums = quick.quickSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
