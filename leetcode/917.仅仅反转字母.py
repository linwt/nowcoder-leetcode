# 方法一：分别提取出字母和其他字符，再将其他字符按原来的索引位置插入到反转后的字母数组中
class Solution(object):
    def reverseOnlyLetters(self, S):
        other, res = [], []
        for i, s in enumerate(S):
            if s.isalpha():
                res.append(s)
            else:
                other.append((i, s))
        res = res[::-1]
        for i, s in other:
            res.insert(i, s)
        return ''.join(res)

# 方法二：从头尾遍历元素，两个都是字母时交换元素的值
class Solution(object):
    def reverseOnlyLetters(self, S):
        S = list(S)
        l, r = 0, len(S)-1
        while l < r:
            if not S[l].isalpha():
                l += 1
            elif not S[r].isalpha():
                r -= 1
            else:
                S[l], S[r] = S[r], S[l]
                l += 1
                r -= 1
        return ''.join(S)