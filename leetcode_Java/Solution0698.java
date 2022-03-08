// 698. 划分为k个相等的子集


class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }
        // 使用位图技巧
        int used = 0;
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    HashMap<Integer, Boolean> memo = new HashMap<>();

    // 方法作用：判断一个桶是否能被装满，即是否有子集和为目标值
    boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择，让下一个桶从 nums[0] 开始选数字
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            // 缓存结果
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            // 剪枝，判断索引 i 的元素是否已使用
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择，使第 i 位置为 1，表示索引 i 的元素已使用
            used |= 1 << i;
            bucket += nums[i];
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择，将第 i 位置为 0，表示索引 i 的元素未使用
            used ^= 1 << i;
            bucket -= nums[i];
        }
        return false;
    }
}