package CampusRecruitment2019;

import java.util.Scanner;

// 排队唱歌
// 直接插入排序并记录交换次数
public class Main049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] high = new int[n];
        for (int i = 0; i < n; i++)
            high[i] = sc.nextInt();

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (high[j] > high[j + 1]) {
                    int temp = high[j];
                    high[j] = high[j + 1];
                    high[j + 1] = temp;
                    res += 1;
                } else {
                    break;
                }
            }
        }
        System.out.println(res);
    }
}