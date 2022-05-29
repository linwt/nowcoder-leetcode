# 每次取出最大的两个元素相减，结果不为0则添加到列表中
class Solution(object):
    def lastStoneWeight(self, stones):
        while len(stones) > 1:
            y = stones.pop(stones.index(max(stones)))
            x = stones.pop(stones.index(max(stones)))
            if x < y:
                stones.append(y-x)
        return stones[0] if stones else 0