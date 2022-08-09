// 47. 全排列 II


/*
回溯：
1、定义全局变量res存放回溯过程得到的所有子结果，定义全局变量track存放回溯过程的临时子结果，定义全局便变量used存放数组元素使用过情况
2、包含重复的元素，因此做选择时，树层要去重，树枝不用去重。去重必须先数组排序
3、调用递归函数，处理得到所有子结果，返回结果
4、定义递归函数
    1）终止条件，子结果大小满足条件，存储子结果
    2）for循环遍历数组：剪枝条件 → 做选择 → 递归 → 撤销选择，回溯
       ① 剪枝条件：当前元素使用过则跳过；或者当前元素未使用过，但同层前面有同样的元素使用过，则跳过重复选择
                  去重代码 i > 0 && nums[i] == nums[i - 1] && !used[i - 1]
                  used[i - 1] = false 表示树层去重，即前一个状态已撤销，为同层。效率更高，避免无效处理。
                  used[i - 1] = true 表示树枝去重，即前一个状态未撤销，为递归，不同层。
       ② 做选择：元素只加入子结果，标记当前元素已使用
       ③ 递归：进入下一层，同样遍历整个数组，通过used标记判断元素是否有效可用
       ④ 回溯：撤销选择，移除子结果最后一个元素，标记当前元素未使用
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}