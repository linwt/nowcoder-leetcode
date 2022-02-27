// 组合总和 II


/*
回溯：
1、思路与'39.组合总和'相同
2、不同点：有重复元素，解集不能包含重复的组合，因此要过滤重复的选择
3、增加剪枝条件：先数组排序，同一层元素做选择时，如果该元素前面出现过，则跳过，因为前面的选择已经包含当前情况了
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int startIndex, int target) {
        int sum = track.stream().mapToInt(x -> x).sum();
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.addLast(candidates[i]);
            backtrack(candidates, i + 1, target);
            track.removeLast();
        }
    }
}