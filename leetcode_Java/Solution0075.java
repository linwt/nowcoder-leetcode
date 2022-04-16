// 75. 颜色分类


/*
单指针：两次遍历，第一次把0交换到前面，第二次把1交换到前面
 */
class Solution {
    public void sortColors(int[] nums) {
        int index = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, index);
                index++;
            }
        }
        for (int i = index; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, index);
                index++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}


/*
双指针：
1、p0、p2指针分别指向首尾
2、遍历到p2指针位置时结束，防止交换完的元素2又被错误地换到前面
3、由于可能存在2换2的情况，使用while循环将元素2交换到尾部，确保当前位置不是元素2
4、当前位置的元素2交换完后，再判断交换元素0到头部
 */
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}