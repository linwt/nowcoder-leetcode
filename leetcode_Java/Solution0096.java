// 96. 不同的二叉搜索树


/*
动态规划：
1、定义dp数组：dp[i] 表示i个节点组成二叉搜索树的种数
2、初始化：dp[0]=1,dp[1]=1,表示0或1个节点时的种数为1。0个节点的种数为1，用于计算左右子树其中一个为空时不影响乘积结果
3、状态转移方程：
  1）根据二叉搜索树的特性，左边的节点值 < 中间的节点值 < 右边的节点值
  2）总共有i个节点时，节点值j作为根节点时，那么左边有j-1个节点，右边有i-j个节点，种数为左边的种数乘以右边的种数，即 dp[i] = dp[j - 1] * dp[i - j];
  2）由于每个节点都可以作为根节点，所以要累加计算每个节点作为根节点时的种数，即 dp[i] += dp[j - 1] * dp[i - j];
4、遍历dp数组填表：
  第一个for循环遍历dp数组，从2个节点开始遍历到n个节点
  第二个for循环遍历每个节点作为根节点时的种数，将种数累加
5、返回结果：最后一个状态就是结果
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}


/*
递归 + 记忆存储
定义递归函数：
1、方法功能：入参是节点数，返回对应的种数
2、终止条件：节点数为0或1时，返回种数为1
3、返回结果：节点数大于1时，要拿左右的种数相乘，返回乘积种数
4、递归逻辑：
  1）总共有n个节点时，节点值i作为根节点时，那么左边有i-1个节点，右边有n-i个节点
  2）由于左右两边的种数同样要计算，因此调用同样的方法获取结果，将左右的种数相乘
  3）由于每个节点都可以作为根节点，所以要累加计算每个节点作为根节点时的种数
  4）计算n个节点的种数，存在重复计算，因此使用记忆存储，存在则直接返回结果
 */
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            count += leftNum * rightNum;
        }
        memo.put(n, count);
        return count;
    }
}