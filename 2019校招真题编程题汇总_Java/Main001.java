package CampusRecruitment2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

// 牛牛找工作
public class Main001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] job = new int[n][2];
        int[] partner = new int[m];

        for (int i = 0; i < n; i++) {
            job[i][0] = sc.nextInt();
            job[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            partner[i] = sc.nextInt();
        }

        // 二维数组按照第一个元素升序排序，即对工作难度升序排序
        // Arrays.sort(job, (o1, o2) -> (o1[0] - o2[0]));            // 写法一
        // Arrays.sort(job, Comparator.comparingInt(o -> o[0]));     // 写法二
        Arrays.sort(job, new Comparator<int[]>() {                  // 写法三
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 对小伙伴能量值升序排序
        int[] partner2 = Arrays.copyOf(partner, m);
        Arrays.sort(partner2);

        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0, power;
        for (int i = 0; i < m; i++) {
            power = partner2[i];
            // 能量值小于最低工作难度，报酬置0
            if (power < job[j][0]) {
                map.put(power, 0);
                continue;
            }
            // 不断提升能量值范围内的工作难度，并逐个将工作难度的报酬置为当前能量范围的最大报酬
            while (j + 1 < n && power >= job[j + 1][0]) {
                if (job[j][1] > job[j + 1][1])
                    job[j + 1][1] = job[j][1];
                j++;
            }
            // 记录当前能量值可获得的最大报酬
            map.put(power, job[j][1]);
        }
        // 按照原能量值顺序输出报酬
        for (int i = 0; i < m; i++)
            System.out.println(map.get(partner[i]));
    }
}
