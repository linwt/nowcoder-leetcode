// 77. 组合


/*
回溯：
1、定义全局变量res列表存放所有结果，定义全局变量track列表存放子结果
2、调用递归函数处理得到结果，返回结果
3、定义递归函数：
   1）终止条件：存放子结果
   2）一层for循环 + 递归 = n层for循环
   3）直接通过参数n控制递归下一层的元素区间
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k);
        return res;
    }

    public void backtrack(int n, int k) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = n; i > 0; i--) {
            track.addLast(i);
            backtrack(i - 1, k);
            track.remove();
        }
    }
}


/*
回溯：
1、通过index索引变量控制递归下一层的元素区间
2、增加剪枝条件，提前排除无效遍历
 */
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }

    private void backtrack(int n, int startIndex, int k) {
        if (k == 0) {                                   // 终止条件
            res.add(new ArrayList<>(track));            // 收集子结果
            return;
        }
        for (int i = startIndex; i <= n - k + 1; i++) {      // for循环控制树的横向遍历
            track.add(i);                               // 处理节点
            backtrack(n, i + 1, k - 1);        // 递归控制树的纵向遍历
            track.remove(track.size() - 1);             // 回溯，撤销节点
        }
    }
}