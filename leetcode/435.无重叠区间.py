# 贪心算法。按结尾升序排序，以最小结尾与其他区间的开头比较，跳过重叠的区间，记录不重叠区间的个数，并更新结尾，再相减得到要移除的区间个数。
class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        if not intervals:
            return 0
        intervals = sorted(intervals, key=lambda k: k[1])
        end, count, n = intervals[0][1], 1, len(intervals)
        for i in range(1, n):
            if intervals[i][0] < end:
                continue
            count += 1
            end = intervals[i][1]
        return n-count