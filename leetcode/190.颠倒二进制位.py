# 方法一：将无符号整数转为二进制，用0补满32位，反转后将二进制格式转为十进制
class Solution:
    def reverseBits(self, n):
        return int(bin(n)[2:].zfill(32)[::-1], 2)

# 方法二：位运算，res每次左移加上n的最后一位，然后n右移去掉最后一位
class Solution:
    def reverseBits(self, n):
        res = 0
        for _ in range(32):
            res = (res<<1) + n%2
            n >>= 1
        return res