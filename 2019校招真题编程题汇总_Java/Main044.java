package CampusRecruitment2019;

import java.util.Scanner;

// 员工考勤记录
public class Main044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1种：全P
        // n种：含1个A
        // (n²-n)/2种：含2个A
        int res = 1 + n + (int)((Math.pow(n, 2) - n) / 2);
        System.out.println(res);
    }
}