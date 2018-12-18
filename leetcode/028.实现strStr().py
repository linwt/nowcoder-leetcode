# 方法一
class Solution(object):
    def strStr(self, haystack, needle):
        if not needle:
            return 0
        elif needle not in haystack:
            return -1
        else:
            return haystack.index(needle)

# 方法二
class Solution(object):
    def strStr(self, haystack, needle):
        return haystack.find(needle)