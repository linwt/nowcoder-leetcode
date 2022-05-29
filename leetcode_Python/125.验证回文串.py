# 方法一：直接判断并提取字母数字
class Solution(object):
    def isPalindrome(self, s):
        res = ''
        for i in s:
            if 'a' <= i <= 'z' or 'A' <= i <= 'Z' or '0' <= i <= '9':
                res += i
        res = res.lower()
        return res == res[::-1]

# 方法二：由方法isalnum()提取字母数字
class Solution(object):
    def isPalindrome(self, s):
        s = ''.join(i for i in s if i.isalnum()).lower()
        return s == s[::-1]