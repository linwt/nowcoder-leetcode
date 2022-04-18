// 438. 找到字符串中所有字母异位词


/*
滑动窗口 + 数组：
1、s的长度小于p时，不能凑成异位词
2、因为字符串中的字符全是小写字母，可以用长度为26的数组记录字母出现的次数
3、设n = len(s), m = len(p)。记录p字符串的字母频次 pCount，和s字符串前m个字母频次 sCount
4、若 pCount 和 sCount 相等，说明两者字母相同，则找到第一个异位词索引 0
5、以p字符串长度m为滑动窗口大小，继续判断s字符串的字符，向右滑动过程，滑动窗口头部增加一个字母，尾部去掉一个字母，增减次数对应记录到sCount
6、每次滑动后都判断 pCount 和 sCount 是否相等，若相等则新增异位词索引

s = "cbaadbac", p = "abca"

sCount = [2,1,1,...], pCount = [2,1,1,...]
c b a a d b a c
↑_____↑
====================
sCount = [2,1,0,1..], pCount = [2,1,1,...]
c b a a d b a c
  ↑_____↑
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < m; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            sCount[s.charAt(i - m) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }
}


/*
滑动窗口 + 双指针
1、定义左右指针，从索引0开始
2、右指针向右滑动过程，记录 sCount 增加字母次数，当同一字母 sCount 次数大于 pCount，说明窗口内出现了多余的字母，需要移除，
  于是左指针向右滑动，缩小窗口范围，并记录 sCount 减少字母次数，直到该字母次数合法
3、每次 右指针扩大窗口 和 左指针缩小窗口 操作结束后，窗口内的字母都是符合p要求的字母，判断一下窗口大小是否等于p的长度，是则说明窗口内字母凑齐，是异位词，记录起始索引

s = "cbaebabacd", p = "abc"

sCount = [1,1,1,0,...], pCount = [1,1,1,0,...]
  c b a d a b c d
  ↑   ↑
left right
====================
sCount = [1,1,1,1,...], pCount = [1,1,1,0,...]
  c b a d a b c d
  ↑     ↑
left  right
====================
sCount = [0,0,0,0,...], pCount = [1,1,1,0,...]
  c b a d a b c d
        ↑ ↑
    right left
====================
sCount = [1,1,1,0,...], pCount = [1,1,1,0,...]
  c b a d a b c d
          ↑   ↑
        left right
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < n) {
            int index = s.charAt(right) - 'a';
            sCount[index]++;
            while (sCount[index] > pCount[index]) {
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == m) {
                res.add(left);
            }
            right++;
        }
        return res;
    }
}