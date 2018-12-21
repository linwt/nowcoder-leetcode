# 统计字符个数存放在字典中，遍历字典。字符个数为偶数则直接累加。
# 个数为奇数则减1后累加，由于回文串只能有一个字符是奇次数，故若有字符个数是奇数最后要再加1
class Solution(object):
    def longestPalindrome(self, s):
        d = collections.Counter(s)
        length = k = 0
        for key in d:
            if d[key]%2 == 0:
                length += d[key]
            else:
                k = 1
                length += d[key]-1
        return length + k