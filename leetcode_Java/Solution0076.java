// 76. 最小覆盖子串


/*
双指针，滑动窗口：
步骤一：不断增加 r 使滑动窗口增大，直到窗口包含了t的所有字符
步骤二：不断增加 l 使滑动窗口缩小，因为是要求最小字串，所以将不必要的字符排除在外，使长度减小，直到碰到一个必须包含的字符，这个时候不能再去掉了，再去掉就不满足条件了，记录此时滑动窗口的长度，并保存最小值
步骤三：让 l 再增加一个位置，这时滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，如此反复，直到 r 超出了字符串s范围

算法过程：
1、变量含义：
    l: 滑动窗口左边界
    r: 滑动窗口右边界
    size: 最小窗口的长度
    count: 当前窗口字符总需求量。当次遍历中还需要几个字符才能够满足包含t中所有字符的条件，最大也就是t的长度
    start: 最小窗口起始位置。如果有效更新滑动窗口，记录这个窗口的起始位置，方便后续找子串
    need：字符需求量数组。正数表示有需求，负数表示有冗余。字符加入窗口时字符需求量减1，移出窗口时字符需求量加1
2、遍历t字符串，记录字符个数，表示窗口中字符的需求量
3、循环条件，右指针向右移动，不超过s的长度
4、右边界字符，如果需求量大于0，则更新count减1，表示字符加入了窗口，总需求量减1
5、每次遍历到的字符，在need数组中该字符需求量减1
6、如果总需求量count为0，说明当前窗口已经包含了t的所有字符
  1）左边界字符有冗余时，则字符需求量加1，左指针右移，缩小窗口大小，字符移出窗口，循环处理
  2）如果当前窗口大小 小于 历史最小窗口，则记录当前最小窗口大小，并将记录此时的左边界位置
  3）左边界字符需求量加1，左边界右移，总需求量count减1，使得当前窗口不包含t的所有字符，重新开始寻找新的满足条件的窗口
7、右边界右移，进入下一轮循环处理

s = "DOABECODEBANC", t = "ABC"
  D  O  A  B  E  C  O  D  E  B  A  N  C
  ↑
 l/r
============== 步骤一 ===================
  D  O  A  B  E  C  O  D  E  B  A  N  C
  ↑              ↑
  l              r
============== 步骤二 ===================
  D  O  A  B  E  C  O  D  E  B  A  N  C
        ↑        ↑
        l        r
============== 步骤三 ===================
  D  O  A  B  E  C  O  D  E  B  A  N  C
           ↑     ↑
           l     r
 */
class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int l = 0, r = 0, count = t.length(), start = 0, size = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {
                count--;
            }
            need[c]--;
            if (count == 0) {
                while (need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}