class Solution(object):
    def findNthDigit(self, n):
        # 数字位数
        digit = 1
        while 1:
            # 不同位数的第一个整数
            first = 10**(digit-1)
            # 该位数里的数字个数
            cur = 9 * first * digit
            if cur >= n:
                # str(first+(n-1)/digit) 获取第n个数所在的整数，(n-1)%digit获取该整数的哪个数
                return int(str(first + (n-1)/digit)[(n-1) % digit])
            # 减去不符合的前cur个数，从更长位数开始判断
            n -= cur
            digit += 1