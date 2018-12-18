# 方法一
# 如果存在这样的子串，那么子串的第一个字符和最后一个字符肯定跟父串的相同
# 因此构建一个新字符串s+s，去掉首尾字符
# 如果此时能在其中找到s，说明存在这样的子串
class Solution(object):
    def repeatedSubstringPattern(self, s):
        return (s+s)[1:-1].find(s) != -1

# 方法二：窗口滑动
class Solution(object):
    def repeatedSubstringPattern(self, s):
        n = len(s)
        # 窗口大小从1遍历到字符串长度一半
        for i in range(1, n/2+1):
            if n%i==0:
                s1 = s[:i]
                j = i
                while j<n and s[j:j+i]==s1:
                    j += i
                if j==n:
                    return True
        return False