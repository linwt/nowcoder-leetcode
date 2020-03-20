package CampusRecruitment2019;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

// 牛牛的闹钟
public class Main007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] clock = new int[N][2];
        for (int i = 0; i < N; i++) {
            clock[i][0] = sc.nextInt();
            clock[i][1] = sc.nextInt();
        }
        int X = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 对闹钟时间排序
        Arrays.sort(clock, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 时钟不同则按照时钟升序排序
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                // 时钟相同则按照分钟升序排序
                return o1[1] - o2[1];
            }
        });

        // 获取能及时到达教室的最晚起床时间
        int latest = A * 60 + B - X;
        int current;
        int i = 0;
        while (i < N) {
            current = clock[i][0] * 60 + clock[i][1];
            // 当前闹钟时间与最晚起床时间比较，小于等于则继续判断下一个闹钟时间
            if (current <= latest)
                i++;
            else
                break;
        }
        System.out.print(clock[i - 1][0] + " " + clock[i - 1][1]);
    }
}