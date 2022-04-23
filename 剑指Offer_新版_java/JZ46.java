// 46. 把数字翻译成字符串


/*
动态规划：
1、先排除几种特殊情况
  1）排除0，无法译码
  2）排除只有一种可能的10和20
  3）排除当0的前面不是1或2时，无法译码
2、定义dp数组：dp[i] 表示前i个字符的译码方式数
3、初始化：填表为1，表示每个字符的译码方式数为1
4、状态转移方程
  1）对于一个字符，如果直接译码，则dp[i] = dp[i - 1]；如果组合译码，则dp[i] = dp[i - 2]
  2）当前字符与前一字符构成 11-19 21-26时，有两种译码方式，则dp[i] = dp[i - 1] + dp[i - 2]
     否则只有一种译码方式，则dp[i] = dp[i - 1]
5、遍历dp数组填表：一个for循环遍历dp数组，根据状态转移方程填表
6、返回结果：最后一个状态就是结果
 */
public class Solution {
    public int solve (String nums) {
        if ("0".equals(nums)) {
            return 0;
        }
        if (nums == "10" || nums == "20") {
            return 1;
        }
        int n = nums.length();
        for (int i = 1; i < n; i++) {
            if (nums.charAt(i) == '0' && nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2') {
                return 0;
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0') || (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) >= '1' && nums.charAt(i - 1) <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}