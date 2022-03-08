// 491. 递增子序列


/*
回溯：
1、使用res存放全局结果，使用track存放子结果
2、调用递归函数，返回结果
3、定义递归函数：
   1）终止条件：子结果长度大于等于2时，收集子结果
   2）剪枝条件：使用used集合，判断同一层元素是否已经使用过，使用过则跳过，因为前面的情况会包含当前的情况
   3）当前元素大于等于子结果中最后一个元素时，进行选择、递归、回溯过程
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        if (track.size() >= 2) {
            res.add(new ArrayList<>(track));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            if (track.size() == 0 || nums[i] >= track.getLast()) {
                track.addLast(nums[i]);
                backtrack(nums, i + 1);
                track.removeLast();
            }
        }
    }
}