class Solution(object):
    def selfDividingNumbers(self, left, right):
        res = []
        for num in range(left, right+1):
            # 包含0则继续判断下一位数
            if str(num).find('0') != -1:
                continue
            # 如果除以自身某位数的余数不为0则跳出循环，否则将该数添加到数组中
            for i in str(num):
                if num % int(i) != 0:
                    break
            else:
                res.append(num)
        return res