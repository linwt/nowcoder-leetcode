# 计算二进制后直接统计'1'的个数
class Solution(object):
    def countBits(self, num):
        res = []
        for i in range(num+1):
            res.append(str(bin(i)).count('1'))
        return res

# 动态规划
# i为偶数时，f(i)=f(i/2)，因为i/2本质上是i的二进制左移一位，低位补零，所以1的数量不变
# i为奇数时，f(i)=f(i-1)+1，因为i-1为偶数，而偶数的二进制最低位一定是0，偶数加1后最低位变为1且不会进位
class Solution2(object):
    def countBits(self, num):
        res = [0]
        for i in range(1, num+1):
            if i%2 == 0:
                res.append(res[i/2])
            else:
                res.append(res[i-1]+1)
        return res

# “与”写法
class Solution3(object):
    def countBits(self, num):
        res = [0]
        for i in range(1, num+1):
            res.append(res[i/2] + (i&1))
        return res