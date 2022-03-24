// 416. 分割等和子集


/*
动态规划：0-1背包，必须先物品再背包，且逆序遍历背包
1、题目：给你一个只包含正整数的非空数组 nums。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
2、题目简化：求数组元素能否凑成和为sum(nums)/2
3、数据校验：数组长度小于2、总和除以2余数不为0、元素最大值大于目标值，则不能分割
4、定义dp数组：dp[i] 表示数组元素能否凑成和为 i
5、初始化：
  1）一维dp数组扩容：增加和为0这一最小规模的情况，方便初始化
  2）dp[0] = true; 表示数组元素能凑成和为0，方便后面推导
6、状态转移方程：dp[i] = dp[i] || dp[i - num];
7、遍历dp数组填表：第一个for循环遍历数组元素，第二个for循环逆序遍历dp数组的未知位置，根据条件获取dp数组的已知位置，
   根据状态转移方程取已知结果汇总计算未知结果。逆序遍历是因为元素只用一次，如果正序遍历会导致元素重复使用。
8、返回结果：最后一个状态就是结果
 */
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] |= dp[i - num];
            }
        }
        return dp[target];
    }
}


/*
1、问题转化：一堆重量为nums[i]，价值也为nums[i]的物品中，能否恰好装满容量为target的背包
2、定义dp数组：dp[i] 表示容量为i的背包最多能装的物品价值
3、状态转移方程：dp[i] = Math.max(dp[i], dp[i - num] + num);
                ↑                ↑               ↑
    新状态,容量为i时最大价值   旧状态,不取num的价值   取num的价值
4、初始化：初始化时默认都为0
5、遍历dp数组填表：第一个for循环遍历数组元素，第二个for循环逆序遍历dp数组的未知位置，根据条件获取dp数组的已知位置，
   根据状态转移方程取已知结果汇总计算未知结果。逆序遍历是因为元素只用一次，如果正序遍历会导致元素重复使用。
6、返回结果：判断最后一个状态的值是否为目标值
 */
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = Math.max(dp[i], dp[i - num] + num);
            }
        }
        return dp[target] == target;
    }
}