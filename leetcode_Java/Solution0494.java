// 目标和


/*
回溯：
1、定义全局变量res累加结果个数
2、调用递归方法，计算累加结果，返回结果
3、定义递归函数
   1）方法参数：除了nums、target需要传递使用，还需增加两个参数，index用于遍历遍历数组指定索引，sum用于计算当前和
   2）终止条件：遍历结束，判断和是否等于目标值，是则res累加
   3）调用递归：两次调用递归函数，分别处理当前元素加或减的情况
 */
class Solution {
    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                res += 1;
            }
            return;
        }
        backtrack(nums, index + 1, sum + nums[index], target);
        backtrack(nums, index + 1, sum - nums[index], target);
    }
}