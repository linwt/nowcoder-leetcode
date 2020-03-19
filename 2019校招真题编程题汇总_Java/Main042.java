package CampusRecruitment2019;

import java.util.Scanner;

// 跳格子游戏
public class Main042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int temp = a;
            a = b;
            b += temp;
        }
        System.out.println(a);
    }
}
