// 509. 斐波那契数


/*
动态规划：自底向上
1、题目：斐波那契数（通常用 F(n) 表示）形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。F(0) = 0，F(1) = 1，F(n) = F(n - 1) + F(n - 2)，其中 n > 1。给定 n ，请计算 F(n)。
2、题目简化：求F(n)
3、定义dp数组：dp[i] 表示F(i)
4、初始化：dp[0] = 0, dp[1] = 1
5、状态转移方程：dp[i] = dp[i-1] + dp[i-2]
6、遍历dp数组填表：一个for循环遍历dp数组的未知位置，根据状态转移方程直接取dp数组几个已知结果计算未知结果
7、返回结果：最后一个状态就是结果
 */
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}


/*
递归：自顶向下
 */
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}


/*
递归 + 备忘录
 */
class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return dfs(memo, n);
    }

    private int dfs(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dfs(memo, n - 1) + dfs(memo, n - 2);
        return memo[n];
    }
}


/*
递归 + 备忘录 + 打印递归树
1、定义打印函数
2、定义全局变量count表示层数，层数越多 缩进越多
3、在“递归函数开头”和“每个return语句之前”添加打印点和输出参数值
4、函数开头使用“count++”，表示先打印再加1。return语句之前使用“--count”，由于要返回了，需要跟进来时层数一致，所以先减1再打印

n = 5
..n = 4
....n = 3
......n = 2
........n = 1
........return 1
........n = 0
........return 0
......return 1
......n = 1
......return 1
....return 2
....n = 2
....return 1
..return 3
..n = 3
..return 2
return 5
 */
public class Solution {
    private int count = 0;

    public int fib(int n) {
        int[] memo = new int[n + 1];
        return dfs(memo, n);
    }

    private int dfs(int[] memo, int n) {
        printLevel(count++);
        System.out.println("n = " + n);
        if (n == 0 || n == 1) {
            printLevel(--count);
            System.out.println("return " + n);
            return n;
        }
        if (memo[n] != 0) {
            printLevel(--count);
            System.out.println("return " + memo[n]);
            return memo[n];
        }
        memo[n] = dfs(memo, n - 1) + dfs(memo, n - 2);
        printLevel(--count);
        System.out.println("return " + memo[n]);
        return memo[n];
    }

    private void printLevel(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("..");
        }
    }
}