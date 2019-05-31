# 拒绝采样
#    a	1	2	3	4	5	6	7
# b
# 1		2	3	4	5	6	7	8
# 2		3	4	5	6	7	8	9
# 3		4	5	6	7	8	9	0
# 4		5	6	7	8	9	0	1
# 5		6	7	8	9	0	1	2
# 6		7	8	9	0	1	2	3
# 7		8	9	0	1	2	3	4
# 去掉右上角
# 6	 7	8
# 7	 8	9
# 8	 9	0
# 则每个数字的出现次数为4次，0-9的概率相同
class Solution(object):
    def rand10(self):
        a, b = rand7(), rand7()
        if a > 4 and b < 4:
            return self.rand10()
        return (a+b) % 10 + 1


#   b  1  2  3  4  5  6  7
# a
# 1    1  2  3  4  5  6  7
# 2    8  9 10  1  2  3  4
# 3    5  6  7  8  9 10  1
# 4    2  3  4  5  6  7  8
# 5    9 10  1  2  3  4  5
# 6    6  7  8  9 10  1  2
# 7    3  4  5  6  7  8  9
class Solution2(object):
    def rand10(self):
        a, b = rand7(), rand7()
        if (a == 6 and b > 5) or a == 7:
            return self.rand10()
        return ((a-1)*7 + b-1) % 10 + 1


# (rand7()-1)*7 等概率产生0 7 14 21 28 35 42
# rand7()-1 等概率产生 0 1 2 3 4 5 6
# 两者相加则等概率产生 0-42，在大的等概率空间中取小范围的数
class Solution3(object):
    def rand10(self):
        while 1:
            num = (rand7()-1)*7 + rand7()-1
            if num < 40:
                return num % 10 + 1



