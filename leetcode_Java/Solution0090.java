// 子集 II


/*
回溯：
1、使用res存放全局结果，使用track存放子结果
2、要先数组排序，才能判断同元素同一层是否使用过。调用递归函数，返回结果
3、定义递归函数：
   1）终止条件：求子集，过程每添加一个元素，子结果都要存入res，不用return
   2）剪枝条件：for循环遍历，要判断当前元素跟前一元素是否相同，相同表示当前层该元素在前面用过了，跳过
   3）做选择加入元素 → 递归下一层 → 回溯移除元素
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        res.add(new ArrayList<>(track));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}


/*
迭代：
1、由于元素存在重复，先数组排序，防止元素顺序不同产生新的子集
2、两层for循环遍历数组，将当前所有子集加上该数，构成新的子集，子集不存在时才加入结果res中，遍历结束后即可获得数组所有子集
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                if (!res.contains(temp)) {
                    res.add(temp);
                }
            }
        }
        return res;
    }
}