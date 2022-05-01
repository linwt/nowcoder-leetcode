// 468. 验证IP地址


/*
分割校验：
1、判断是否ipv4
  1）ip长度大于0且尾字符是'.'则返回false
  2）根据'.'分割成数组，注意'.'是转义字符，需要用'\'处理为原字符，'\'也是转义字符所以也要再处理一遍，最终为'\\.'
  3）数组长度不等于4，返回false
  4）子串长度为0或大于3，返回false
  5）子串长度大于1且存在前置0，返回false
  6）子串存在非数字，返回false
  7）子串转化成数字后大于255，返回false
  8）否则返回true
2、判断是否ipv6
  1）ip长度大于0且尾字符是':'则返回false
  2）根据'.'分割成数组，数组长度不等于8，返回false
  3）子串长度为0或大于4，返回false
  4）子串存在0-9、a-f、A-F以外的字符，返回false
  5）否则返回true
 */
class Solution {
    public String validIPAddress(String queryIP) {
        if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIPv4(String queryIP) {
        if (queryIP.length() > 0 && queryIP.charAt(queryIP.length() - 1) == '.') {
            return false;
        }
        String[] array = queryIP.split("\\.");
        if (array.length != 4) {
            return false;
        }
        for (String s: array) {
            if (s.length() == 0 || s.length() > 3) {
                return false;
            }
            if (s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }
            int num;
            try {
                num = Integer.valueOf(s);
            } catch (Exception e) {
                return false;
            }
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String queryIP) {
        if (queryIP.length() > 0 && queryIP.charAt(queryIP.length() - 1) == ':') {
            return false;
        }
        String[] array = queryIP.split(":");
        if (array.length != 8) {
            return false;
        }
        for (String s : array) {
            if (s.length() == 0 || s.length() > 4) {
                return false;
            }
            if (!s.matches("[0-9a-fA-F]+")) {
                return false;
            }
        }
        return true;
    }
}