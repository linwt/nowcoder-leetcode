// 93. 复原 IP 地址


/*
回溯：
1、确定递归参数：
  1）startIndex一定是需要的，因为不能重复分割，记录下一层递归分割的起始位置
  2）还需要一个变量pointNum，记录添加逗点的数量
2、递归终止条件：
  1）本题明确要求只会分成4段，所以不能用切割线切到最后作为终止条件，而是分割的段数作为终止条件。
  2）pointNum表示逗点数量，pointNum为3说明字符串分成了4段了。然后验证一下第四段是否合法，如果合法就加入到结果集里。
3、单层递归逻辑：
  1）for循环中[startIndex, i]这个区间就是截取的子串，需要判断这个子串是否合法。如果合法就在字符串后面加上符号.表示已经分割。如果不合法就结束本层循环。
  2）递归调用时，下一层递归的startIndex要从i+2开始（因为在字符串中加入了分隔符.），同时记录分割符的数量pointNum要加1。回溯的时候pointNum要减1。
  3）字符串参数在递归函数入参时构造，不影响本层原来的参数，这是回溯隐藏的写法。
 */
class Solution {
    private List<String> res = new ArrayList<>();
    private int pointNum = 0;

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int startIndex) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                pointNum++;
                backtrack(s.substring(0, i + 1) + "." + s.substring(i + 1), i + 2);
                pointNum--;
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}