# 方法一：利用反转字符串比较
class Solution(object):
    def validPalindrome(self, s):
        n = len(s)
        if n < 3:
            return True

        s2 = s[::-1]
        i = 0
        while i < len(s) and s[i] == s2[i]:
            i += 1
        return s[i:n-1-i] == s2[i+1:n-i] or s[i+1:n-i] == s2[i:n-1-i]

# 方法二：在原字符串上比较
class Solution(object):
    def validPalindrome(self, s):
        n = len(s)
        if n < 3:
            return True

        l, r = 0, n-1
        while l < r and s[l] == s[r]:
            l += 1
            r -= 1
        if l >= r:
            return True
        return s[l+1:r+1] == s[l+1:r+1][::-1] or s[l:r] == s[l:r][::-1]