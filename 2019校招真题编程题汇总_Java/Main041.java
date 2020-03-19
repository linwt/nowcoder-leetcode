package CampusRecruitment2019;

import java.util.HashMap;
import java.util.Scanner;

// X游戏
public class Main041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            if ((str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9")) && (!str.contains("3") && !str.contains("4") && !str.contains("7")))
                res++;
        }
        System.out.println(res);
    }
}

/*
public class Main041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 记录旋转规则
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('2', '5');
        map.put('5', '2');
        map.put('6', '9');
        map.put('9', '6');
        int res = 0;
        Character newChar;
        for (int i = 1; i <= n; i++) {
            // 数字转化为字符数组
            String str = String.valueOf(i);
            char[] ch = str.toCharArray();
            // 判断是否全部为有效数字
            boolean flag = true;
            for (int j = 0; j < ch.length; j++) {
                newChar = map.get(ch[j]);
                // 获取并替换旧字符
                if (newChar != null) {
                    ch[j] = newChar;
                } else {
                    // 包含无效数字
                    flag = false;
                    break;
                }
            }
            // 旋转后数字与原来的不同
            if (flag && !String.valueOf(ch).equals(str))
                res += 1;
        }
        System.out.println(res);
    }
}
 */