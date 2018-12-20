# 在两个字符串长度范围内，用两个指针指向两个字符串的首部，若两个元素相同则两指针各前进一步，否则typed的指针前进一步
class Solution(object):
    def isLongPressedName(self, name, typed):
        i = j = 0
        while i < len(name) and j < len(typed):
            if name[i] == typed[j]:
                i += 1
                j += 1
            else:
                j += 1
        return i == len(name)