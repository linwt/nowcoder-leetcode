package CampusRecruitment2019;

import java.util.Scanner;
import java.util.Arrays;

// 俄罗斯方块
public class Main009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] count = new int[n];
        int[] locat = new int[m];
        for (int i = 0; i < m; i++)
            locat[i] = sc.nextInt();

        // 统计每列的方块数，最低一列即为所获分数
        for (int i = 0; i < m; i++)
            count[locat[i] - 1]++;
        int res = Arrays.stream(count).min().getAsInt();
        System.out.println(res);
    }
}
