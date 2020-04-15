package CampusRecruitment2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


// 牛牛的背包问题
public class Main008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        long w = Long.parseLong(str1[1]);

        String[] str2 = bufferedReader.readLine().split(" ");
        long[] v = new long[n];
        for (int i = 0; i < n; i++)
            v[i] = Long.parseLong(str2[i]);

        // 计算零食体积总和，总和小于等于背包容量，则有2^n种
        long sum = 0;
        for (long l : v)
            sum += l;
        if (sum <= w) {
            System.out.println((long) Math.pow(2, n));
            return;
        }
        // 否则，递归累加计算
        System.out.println(loop(v, n - 1, w));
    }

    private static int loop(long[] v, int i, long w) {
        // 边界条件，最后一袋零食
        if (i == 0) {
            // 背包容量≥零食体积，可选择放入或不放入两种情况
            if (w >= v[0])
                return 2;
            // 只能选择不放入一种情况
            else
                return 1;
        }
        // 边界条件，背包容量为0，只能选择不放入一种情况
        if (w == 0)
            return 1;

        // 背包容量足够装下这袋零食，则可选择放入或不放入
        if (w - v[i] >= 0)
            return loop(v, i - 1, w - v[i]) + loop(v, i - 1, w);
        // 否则，只能选择不放入
        else
            return loop(v, i - 1, w);
    }
}



/*
// 动态规划，二维数组
public class Main008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= w; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - v[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - v[i - 1]];
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}
*/



/*
// 动态规划，一维数组
public class Main008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int[] dp = new int[w + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = w; j >= v[i]; j--) {
                dp[j] = dp[j] + dp[j - v[i]];
            }
        }
        System.out.println(dp[w]);
    }
}
*/