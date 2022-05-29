# 方法一
class Solution(object):
    def longestCommonPrefix(self, strs):
        if not strs:
            return ''
        # 遍历索引
        for i in range(len(strs[0])):
            # 遍历每个字符串
            for str in strs:
                # 索引超过字符串长度或字符不相等
                if len(str) <= i or strs[0][i] != str[i]:
                    return strs[0][:i]
        return strs[0]

# 方法二：使用python函数
class Solution(object):
    def longestCommonPrefix(self, strs):
        return os.path.commonprefix(strs)