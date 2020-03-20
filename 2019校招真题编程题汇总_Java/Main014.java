package CampusRecruitment2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 塔
public class Main014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] tower = new int[n][2];
        for (int i = 0; i < n; i++) {
            tower[i][0] = i + 1;        // 记录初始位置
            tower[i][1] = sc.nextInt(); // 记录高度
        }

        // 按照高度升序排序
        Arrays.sort(tower, Comparator.comparingInt(o -> o[1]));

        // 计算余数，可知总体平均后高度差是0还是1
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += tower[i][1];
        int rest = sum % n;

        ArrayList<String> list = new ArrayList<>();
        // 最高减最低差大于0，且有剩余操作次数
        while (tower[n - 1][1] - tower[0][1] > 0 && k > 0) {
            // 余数大于0且高度差为1，说明总体已经最优
            if (rest > 0 && tower[n - 1][1] - tower[0][1] == 1) break;
            // 最高塔往最低塔移动立方块
            tower[0][1]++;
            tower[n - 1][1]--;
            k--;
            // 记录初始相对位置的移动操作
            list.add(tower[n - 1][0] + " " + tower[0][0]);
            // 一次操作后数组重新升序排序
            Arrays.sort(tower, Comparator.comparingInt(o -> o[1]));
        }

        int min = tower[0][1], max = tower[n - 1][1];
        int delta = max - min;
        System.out.println(delta + " " + list.size());
        for (String str : list)
            System.out.println(str);
    }
}