// 494. 目标和


/*
回溯：
1、定义全局变量res累加结果个数
2、调用递归方法，计算累加结果，返回结果
3、定义递归函数
   1）方法参数：除了nums、target需要传递使用，还需增加两个参数，index用于遍历遍历数组指定索引，sum用于计算当前和
   2）终止条件：遍历结束，判断和是否等于目标值，是则res累加
   3）调用递归：两次调用递归函数，分别处理当前元素加或减的情况
 */
class Solution {
    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                res += 1;
            }
            return;
        }
        backtrack(nums, index + 1, sum + nums[index], target);
        backtrack(nums, index + 1, sum - nums[index], target);
    }
}


/*
动态规划，0-1背包，二维dp数组
1、题目解析：
  每个数字都有两种状态：被进行“+”，或者被进行“-”，因此可以将数组分成A和B两个部分：A部分的数字全部进行“+”操作，B部分的数字全部进行“-”操作。
  设数组的和为sum，A部分的和为sumA，B部分的和为sumB，根据上面的分析，我们可以得出：
  sumA + sumB = sum (1)
  sumA - sumB = target (2)
  将(1)式与(2)式相加，可以得到：2sumA = sum + target (3)  即：sumA = (sum + target) / 2
  自此，原问题可以转化为0-1背包问题：有一些物品，第 i 个物品的重量为nums[i]，背包的容量为sumA，问：有多少种方式将背包【恰好装满】
2、数据校验：由公式推导得出的sumA，即bagSize，必须为整数且大于0，否则不能凑出。
3、定义dp数组：dp[i][j] 表示在前 i 个数字中，凑出和为 j 的组合数，即方法数
  注意是求组合数，不是排列数，因为数组是有序的，只是在数字前面添加符号，不能改变数字的顺序。
4、初始化：
  1）二维dp数组扩容：增加 0个数字、和为0 这一最小规模的情况
  2）dp[i][0] 表示在前i个数字中，凑出和为0的组合数，容量不够放所以选择都不放时和为0，有1种方法，因此dp[0][0] = 1
5、状态转移方程：
  if (j < nums[i - 1])  dp[i][j] = dp[i - 1][j];  // 容量不够放，所以只能选择不放
  else  dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];   // 容量够放，可以将 不放时装满 和 放时装满 的组合数相加
                        不放                放
6、遍历dp数组填表：先遍历数字，再遍历背包，背包正序遍历。数字应该从第1个数字开始，而背包应该从容量为0开始。
  因为，题目中指出了nums[i] >=0，即可能为0，因此需要考虑到背包容量也为0的情况。
  比如，第1个数字为0，背包容量也为0时，有两种选择：选择0 或者 不选，这两种选择都可以填满容量为0的背包
7、返回结果：最后一个状态就是结果

nums=[0,1,2,5]，target=4，bagSize=6，行代表数字，列代表背包容量，首列初始化为1，从上到下，从左到右更新
   0  1  2  3  4  5  6
x  1  0  0  0  0  0  0
0  2  0  0  0  0  0  0
1  2  2  0  0  0  0  0
2  2  2  2  2  0  0  0
5  2  2  2  2  0  2  2
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        if (bagSize < 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][bagSize + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][bagSize];
    }
}


/*
动态规划，0-1背包，一维dp数组
1、题目简化：有一些物品，第 i 个物品的重量为nums[i]，背包的容量为sumA，求有多少种方式将背包【恰好装满】
2、定义dp数组：dp[j] 表示凑出和为 j 的组合数，即方法数
3、状态转移方程：dp[j] = dp[j] + dp[j - num];
   1）等式右侧 dp[j] 表示前 i-1 个物品凑出和为 j 的组合数，在本轮中表示“不放”第i个物品就凑出和为j的组合数
   2）等式右侧 dp[j - num] 表示前 i-1 个物品凑出和为 j-nums[i] 的组合数，在本轮中表示“放”第i个物品刚好凑出和为j的组合数
   3）等式左侧 dp[j] 表示前 i 个物品凑出和为 j 的组合数，是由“不放”和“放”两种情况下凑出和为j的组合数相加
4、初始化：dp[0] = 1; 装满容量为0的背包，有1种方法，就是装0件物品
5、遍历dp数组填表：先遍历数字，再遍历背包，背包倒序遍历
   1）一维数组是滚动数组，每一轮滚动遍历中，未遍历的表示上一轮的旧状态，正在遍历的表示正在计算的状态，遍历过的表示本轮的新状态
   2）本轮遍历中，背包容量不够放时，只能选择不放，旧状态就是“不放”，所以只遍历背包容量足够的情况即可(j >= num)
   3）倒序遍历是为了正确使用旧状态。如果是正序遍历就会在前面覆盖旧状态，求新状态时用到了前面被覆盖过的状态，表示的含义是物品重复使用，属于完全背包
6、返回结果：最后一个状态就是结果
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        if (bagSize < 0) {
            return 0;
        }
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagSize; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagSize];
    }
}