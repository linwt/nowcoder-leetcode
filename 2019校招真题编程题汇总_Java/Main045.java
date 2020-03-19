package CampusRecruitment2019;

import java.util.Scanner;

// 解码方法
// 动态规划,dp[i]表示数字串前i个数字所有的解码方案
public class Main045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 当前字符未组合时，当前解码方案等于上一种解码方案
            if (str.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            // 当前字符可组合时，解码方案加上'去除最后两个字符时的解码方案'
            if (i >= 2 && (str.charAt(i - 2) == '1' || (str.charAt(i - 2) == '2' && str.charAt(i - 1) <= '6')))
                dp[i] += dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}