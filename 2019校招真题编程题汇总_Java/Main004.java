package CampusRecruitment2019;

import java.util.Scanner;

// 迷路的牛牛
public class Main004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        // 方向抵消
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'L')
                res--;
            else
                res++;
        }
        // 取余判断最后方向
        res %= 4;
        if (res == 0)
            System.out.println('N');
        else if (Math.abs(res) == 2)
            System.out.println('S');
        else if (res == 1 || res == -3)
            System.out.println('E');
        else
            System.out.println('W');
    }
}
