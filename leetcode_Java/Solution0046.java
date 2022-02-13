// 全排列


/*
回溯：
1、定义全局变量res存放回溯过程得到的所有子结果
2、定义局部变量track存放回溯过程的临时子结果
3、调用递归函数，处理得到所有子结果，返回结果
4、定义递归函数
    1）终止条件，存储子结果
    2）for循环：剪枝条件 → 做选择 → 递归 → 撤销选择 → 回溯
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}