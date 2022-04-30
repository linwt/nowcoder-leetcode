// 165. 比较版本号


/*
双指针：
1、同时遍历两个字符串，直到全部遍历完
2、双指针分别遍历两个字符串，获取逗号分隔的修订号，将字符转化成数字，比较两个修订号的大小，大于或小于则返回结果1或-1，相同则继续判断下一个修订号，
   遍历结束后仍没有返回，说明修订号全部相同，返回0

 12.01.33  12.11.33
   ↑         ↑        ==>  12 = 12
   i         j
===================================
 12.01.33  12.11.33
      ↑         ↑     ==>  1 < 11
      i         j
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            int num1 = 0, num2 = 0;
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i++) - '0';
            }
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j++) - '0';
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}


/*
字符串分割：两个字符串根据'.'分割成字符串数组，同时遍历两个数组，把修订号转化成数字，分别比较修订号
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n1 = s1.length, n2 = s2.length;
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            int num1 = 0, num2 = 0;
            if (i < n1) {
                num1 = Integer.parseInt(s1[i++]);
            }
            if (j < n2) {
                num2 = Integer.parseInt(s2[j++]);
            }
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }
}