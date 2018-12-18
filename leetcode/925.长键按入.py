# 方法一：遍历name为基础
class Solution(object):
    def isLongPressedName(self, name, typed):
        i = j = 0
        # 遍历name字符
        while i < len(name):
            # name中字符未完，typed字符已经结束
            if j >= len(typed):
                return False
            elif name[i] == typed[j]:
                i += 1
                j += 1
            elif i >= 1 and typed[j] == typed[j-1]:
                j += 1
            else:
                return False
        return True

# 方法二：遍历typed为基础
class Solution(object):
    def isLongPressedName(self, name, typed):
        i, name_len = 0, len(name)
        # 遍历typed字符
        for j in range(len(typed)):
            # name字符未结束
            if i < name_len and name[i] == typed[j]:
                i += 1
            elif j == 0 or typed[j] != typed[j-1]:
                return False
        # typed字符遍历完后，判断name字符是否也结束
        return i == name_len