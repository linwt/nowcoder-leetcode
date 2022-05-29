# n维空间定义坐标：按查找时间1h，猪15分钟内死去计算，1只猪最多可检测5只桶，2只猪最多可检测25只桶...
class Solution(object):
    def poorPigs(self, buckets, minutesToDie, minutesToTest):
        # 一只猪在实验时间内最多可检测水桶数量
        times = minutesToTest/minutesToDie+1
        num = 0
        while pow(times, num) < buckets:
            num += 1
        return num