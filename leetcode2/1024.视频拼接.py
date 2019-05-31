# 贪心，每一步都走可到范围内下一步最远的那一步
class Solution(object):
    def videoStitching(self, clips, T):
        d = {}
        for clip in clips:
            # 用字典记录每个起点的最远终点
            d[clip[0]] = max(d.get(clip[0], 0), clip[1])
        res = 1
        start = s = 0
        end = e = reach = d.get(0, 0)
        while reach < T:
            # 在已有范围内搜寻可到最远距离
            for cur in range(start + 1, end + 1):
                if d.get(cur, 0) > reach:
                    # 记录下一轮的起点和终点
                    s, e, reach = cur, d[cur], d[cur]
            # 本轮停留在原地
            if s == start and e == end:
                return -1
            start, end = s, e
            res += 1
        return res