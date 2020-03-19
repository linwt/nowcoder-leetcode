package CampusRecruitment2019;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

// 挑选代表
public class Main051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] region = new int[n][2];
        for (int i = 0; i < n; i++) {
            region[i][0] = sc.nextInt();
            region[i][1] = sc.nextInt();
        }

        Arrays.sort(region, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 差大于0则交换位置，按照数组第二个元素升序排序
                return a[1] - b[1];
            }
        });
        // 取区间的最后两个数
        int p2 = region[0][1] - 1, p1 = region[0][1], res = 2;
        for (int i = 1; i < n; i++) {
            int a = region[i][0];
            int b = region[i][1];
            // 当前区间包含了前一区间的两个数
            if (a <= p1 && p1 <= b && a <= p2 && p2 <= b)
                continue;
            // 当前区间包含了前一区间的一个数
            else if (a <= p1 && p1 <= b) {
                p2 = p1;
                p1 = b;
                res += 1;
            // 当前区间不包含前一区间的数，需要获取当前区间的最后两个数
            } else {
                p2 = b - 1;
                p1 = b;
                res += 2;
            }
        }
        System.out.println(res);
    }
}