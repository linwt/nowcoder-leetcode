// 组合总和


/*
回溯：
1、定义全局变量res存放回溯过程得到的所有子结果
2、定义全局变量track存放回溯过程的临时子结果
3、调用递归函数，处理得到所有子结果，返回结果
4、定义递归函数
    1）终止条件，总和等于目标值，存储子结果
    2）剪枝条件，总和大于目标值，结束
    3）for循环遍历数组，做选择 → 递归 → 撤销选择，回溯
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int index, int target) {
        int sum = track.stream().mapToInt(x -> x).sum();
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            backtrack(candidates, i, target);
            track.removeLast();
        }
    }
}