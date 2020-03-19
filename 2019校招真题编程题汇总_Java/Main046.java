package CampusRecruitment2019;

import java.util.Scanner;
import java.util.Arrays;

// 漂流船问题
// 贪心，先排序数组，再用双指针从左右两端向内移动，两人体重和满足限制条件则两个人一只船，否则重的人单独一只船
public class Main046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] people = sc.nextLine().split(" ");
        int limit = sc.nextInt();

        Arrays.sort(people);
        int l = 0, r = people.length - 1, res = 0;
        while (l <= r) {
            if (Integer.parseInt(people[l]) + Integer.parseInt(people[r]) <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            res += 1;
        }
        System.out.println(res);
    }
}