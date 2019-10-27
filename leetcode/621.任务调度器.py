# 完成所有任务的最短时间取决于出现次数最多的任务数量
# A -> (单位时间) -> (单位时间) -> A -> (单位时间) -> (单位时间) -> A
# 计算过程： (出现最多次数的任务的次数 - 1) * (n + 1) + (出现最多次数的任务个数)
class Solution(object):
    def leastInterval(self, tasks, n):
        d = {}
        # 统计每个任务的次数，并按次数归类存放在字典中
        for task in set(tasks):
            count = tasks.count(task)
            if count not in d:
                d[count] = [task]
            else:
                d[count] += [task]
        # 获取最大次数
        max_count = max(d.keys())
        # 计算最短时间
        res = (max_count - 1) * (n + 1) + len(d[max_count])
        # 当出现次数最多的任务中间的单位时间填满后，仍有其他次数小的任务需要执行
        # 用上面的计算方法会使最短次数比原数组长度短，此时应返回原数组长度
        if res < len(tasks):
            return len(tasks)
        return res