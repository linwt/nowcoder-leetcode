// 组合总和 III


/*
回溯思路：
1、画n叉树
2、开始套模板，定义全局变量全部结果res、子结果track，调用回溯方法处理，返回结果
3、定义递归函数
   1）分析方法参数，需要index控制下一层区间
   2）终止条件，个数满足，判断子结果和，收集子结果
   3）做选择，加入子结果
   4）递归，开启下一层for循环
   5）回溯，撤销选择
   6）优化，剪枝条件，过滤无效遍历
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedLast<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1);
        return res;
    }

    private void backtrack(int k, int n, int startIndex) {
        if (k == 0) {
            int sum = track.stream().mapToInt(x -> x).sum();
            if (sum == n) {
                res.add(new ArrayList<>(track));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - k + 1; i++) {
            track.addLast(i);
            backtrack(k - 1, n, i + 1);
            track.removeLast();
        }
    }
}