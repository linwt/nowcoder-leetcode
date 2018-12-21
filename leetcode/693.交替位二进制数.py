# 方法一：判断二进制数中是否存在'00'或'11'字符串
class Solution(object):
    def hasAlternatingBits(self, n):
        n = bin(n)
        return '00' not in n and '11' not in n

# 方法二：先右移再异或，最后与运算，与运算结果为0则交替
class Solution(object):
    def hasAlternatingBits(self, n):
        t = n^(n>>1)
        return not (t & t+1)

# 方法三：遍历二进制数的每个字符，判断相邻两字符是否相等
class Solution(object):
    def hasAlternatingBits(self, n):
        n = bin(n)[2:]
        for i in range(len(n)-1):
            if n[i] == n[i+1]:
                return False
        return True

# 方法四：将二进制数的每一位交替放到两个数组中，判断数组是否为同一字符且两数组字符不相等
class Solution(object):
    def hasAlternatingBits(self, n):
        if n <= 1:
            return True
        n = bin(n)[2:]
        res1, res2 = [], []
        for i in range(len(n)):
            if i%2 == 0:
                res1.append(n[i])
            else:
                res2.append(n[i])
        return len(set(res1))==1 and len(set(res2))==1 and set(res1)!=set(res2)