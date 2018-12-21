# 用两个指针指向两个排序后数组的首部，比较两个指针指向的元素。若饼干尺寸满足胃口值则两指针各前进一步，否则饼干指针前进一步
class Solution(object):
    def findContentChildren(self, g, s):
        g.sort()
        s.sort()
        len_g, len_s = len(g), len(s)
        i = j = 0
        while i<len_g and j<len_s:
            if g[i] <= s[j]:
                i += 1
                j += 1
            else:
                j += 1
        return i