# 利用栈弹出元素，使前面的数字尽可能小
class Solution(object):
    def removeKdigits(self, num, k):
        res = []
        for n in num:
            while res:
                if not k or n >= res[-1]:
                    res.append(n)
                    break
                else:
                    res.pop()
                    k -= 1
            else:
                if n != '0':
                    res.append(n)
        res = res[:len(res)-k]
        return ''.join(res) if res else '0'