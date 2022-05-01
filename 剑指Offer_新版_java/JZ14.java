// 14. 剪绳子


/*
动态规划：
1、题目简化：求长度为n的绳子能得到的最大乘积
2、定义dp数组：dp[i] 表示长度为i的绳子能得到的最大乘积
3、初始化：dp[0]=1, dp[1]=1
4、状态转移方程
  先把长度为i的绳子拆成两部分，一部分是j，另一部分是i-j，那么会有下面4种情况
  1）j和i-j都不能再拆了  dp[i] = j * (i-j);
  2）j能拆，i-j不能拆   dp[i] = dp[j] * (i-j);
  3）j不能拆，i-j能拆   dp[i] = j * dp[i-j];
  4）j和i-j都能拆      dp[i] = dp[j] * dp[i-j];
  取上面4种情况的最大值即可，即两部分在能拆和不能拆时取最大值，然后相乘。由于有多种分段方式，所以多结果再进行比较取最大，整理得到递推公式
  dp[i] = max(dp[i], max(j, dp[j]) * max(i - j, dp[i - j]));
5、遍历dp数组填表
  1）长度为i的绳子能得到的最大乘积，即dp[i]，需要先计算dp[1]到dp[i-1]的值，自底向上计算
  2）第一个for循环遍历绳子长度，从小到大，从2开始到目标值
  3）第二个for循环遍历绳子分段后左半部分的长度，遍历到绳子长度一半即可，因为再往后遍历的情况前面已经计算了
6、返回结果
 */
public class Solution {
    public int cutRope (int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[target];
    }
}


/*
数学：
1、一个整数先把他分成两部分，x+y=n（假设x>=y并且x-y<=1,也就是说x和y非常接近）那么乘积是x*y。
  然后我们再把这两部分的差放大(x+1)+(y-1)=n(假设x>=y)；他们的乘积是（x+1）*(y-1)=x*y-(x-y)-1，很明显是小于x*y的。
  所以我们得出结论，如果把整数n分为两部分，那么这两部分的值相差越小乘积越大。
  同理还可以证明如果分成3部分，4部分……也是相差越小乘积会越大。
2、如果我们把长度为n的绳子分为x段，则每段只有在长度相等的时候乘积最大，那么每段的长度是n/x。所以他们的乘积是(n/x)^x。
  我们来对这个函数求导 y=(n/x)^x
  通过对函数求导我们发现，当x=n/e的时候，也就是每段绳子的长度是n/x=n/(n/e)=e的时候乘积最大。
  我们知道e=2.718281828459。而题中我们的绳子剪的长度都是整数，所以不可能取e，我们只能取接近e的值，也就是3的时候乘积最大。
3、但也有例外，当n<=4的时候会有特殊情况，因为2*2>1*3
4、如果n大于4，我们不停的把绳子减去3，并且结果不断乘3，最终结果再乘剩余的target
 */
public class Solution {
    public int cutRope (int target) {
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int res = 1;
        while (target > 4) {
            target -= 3;
            res *= 3;
        }
        return res * target;
    }
}


/*
1、以上解法通过公式直接计算
2、x表示余数，余1时跟一个3凑成4进行乘积更大，余2时最后乘上即可，余0则刚好等分直接计算
3、y表示有多少段3,
 */
public class Solution {
    public int cutRope(int target) {
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int x = target % 3;
        int y = target / 3;
        if (x == 1) {
            return (int) Math.pow(3, y - 1) * 4;
        } else if (x == 2) {
            return (int) Math.pow(3, y) * 2;
        } else {
            return (int) Math.pow(3, y);
        }
    }
}


/*
快速幂
 */
public class Solution {
    public int cutRope(int target) {
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int x = target % 3;
        int y = target / 3;
        if (x == 1) {
            return pow(3, y - 1) * 4;
        } else if (x == 2) {
            return pow(3, y) * 2;
        } else {
            return pow(3, y);
        }
    }

    private int pow(int base, int num) {
        int res = 1;
        while (num > 0) {
            if ((num & 1) == 1) {
                res *= base;
            }
            base *= base;
            num >>= 1;
        }
        return res;
    }
}