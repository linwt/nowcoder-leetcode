class Solution(object):
    def partition(self, s):
        # 参数：字符串，输出数组
        def cut(s, output):
            # 终止条件，字符串全部切割完毕，将输出数组添加到全局数组中，返回空结束递归
            if not s:
                res.append(output)
                return
            # 遍历字符串从头开始的每个子串
            for i in range(1, len(s)+1):
                # 若该子串为回文串
                if s[:i] == s[:i][::-1]:
                    # 则调用递归，字符串和输出数组动态更新，逐步产生结果，递归完成后回溯，继续搜索下一个结果
                    cut(s[i:], output + [s[:i]])

        res = []
        cut(s, [])
        return res


class Solution2(object):
    def partition(self, s):
        # 字符串为空，返回包含一个空数组的数组
        if not s:
            return [[]]
        # 当前字符串的回文串结果数组
        res = []
        for i in range(len(s)):
            temp = s[:i+1]
            if temp == temp[::-1]:
                # 遍历获取余下字符串的回文串结果数组
                for j in self.partition(s[i+1:]):
                    # 当前字符串的首个回文串添加到已有回文串数组中，构成新的回文串数组
                    res.append([temp] + j)
        # 返回当前字符串的回文串结果数组
        return res


class Solution3(object):
    def __init__(self):
        self.res = []
        self.output = []

    def partition(self, s):
        # 终止条件，字符串全部切割完毕，将输出数组添加到全局数组中，返回空结束递归
        if not s:
            self.res.append(self.output)
            return
        for i in range(1, len(s)+1):
            if s[:i] == s[:i][::-1]:
                # 先更新输出数组，递归回溯后再弹出新值，还原输出数组，搜索下一种情况
                self.output.append(s[:i])
                self.partition(s[i:])
                self.output.pop()
        return self.res