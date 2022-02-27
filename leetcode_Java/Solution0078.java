// 子集


/*
回溯：
1、不需要剪枝，求子集的过程就是要遍历整棵树
2、不需要终止条件，startIndex达到数组长度时for循环就自动终止了
3、求子集，则每做一次选择就要收集一次结果
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        res.add(new ArrayList<>(track));
        for (int i = startIndex; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}


/*
回溯：
1、通过递归实现遍历数组，方法参数传入数组索引
2、每个元素有加入和不加入两种可能，通过两次回溯递归处理两种情况
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList(track));
            return;
        }
        track.addLast(nums[index]);
        backtrack(nums, index + 1);
        track.removeLast();
        backtrack(nums, index + 1);
    }
}


/*
迭代：
两层for循环遍历数组，将当前所有子集加上该数，构成新的子集，遍历结束后即可获得数组所有子集
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}