// 43. 字符串相乘


/*
模拟相乘：遍历num2每一位与num1进行相乘，将每一步的结果进行累加
1、其中一个数为0，则乘积为0
2、从右到左遍历num2，根据当前位数对结果补0，获取当前位置数字n1
3、从右到左遍历num1，如果num1遍历完了但当前进位大于0则赋值数字为0，否则直接获取，最终得到当前位置数字n2
4、两数相乘得到乘积，取个位存入结果字符串，取十位作为进位。直到计算完num2的一位与num1的所有位乘积
5、num2每计算完一位后，就要把当前计算结果与前面的计算结果进行字符串相加，最终得到num2每一位乘积结果的和

num1     1 2 3
num2     4 5 6
     ---------
         7 3 8
       6 1 5 0
     4 9 2 0 0
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = len2 - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            for (int k = 0; k < len2 - 1 - i; k++) {
                temp.append("0");
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = len1 - 1; j >= 0 || carry > 0; j--) {
                int n1 = j >= 0 ? num1.charAt(j) - '0' : 0;
                int multiply = (n1 * n2 + carry);
                temp.append(multiply % 10);
                carry = multiply / 10;
            }
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    // 415. 字符串相加
    private String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            res.append(sum % 10);
        }
        return res.reverse().toString();
    }
}


/*
两数相乘位置规律：
1、乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
2、num1[i] x num2[j] 的结果 multiply 位数为两位，"0x" 或 "xy" 的形式，其第一位位于 cal[i+j]，第二位位于 cal[i+j+1]
3、从右到左遍历num1和num2，分别取出两个数字相乘，再加上一步乘积的十位防止被覆盖，然后将结果的个位和十位存入cal数组
4、遍历cal数组，构造结果字符串返回

            1 2 3   ==> 2的索引i为1
              4 5   ==> 4的索引j为0
        ----------
              1 5
            1 0
          0 5
        ----------
            1 2
          0 8       ==> cal[i+1] cal[i+j+1]
        0 4
        ----------
cal     0 1 2 3 4

 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] cal = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int multiply = (n1 * n2 + cal[i + j + 1]);
                cal[i + j + 1] = multiply % 10;
                cal[i + j] += multiply / 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cal.length; i++) {
            if (i == 0 && cal[i] == 0) {
                continue;
            }
            res.append(cal[i]);
        }
        return res.toString();
    }
}