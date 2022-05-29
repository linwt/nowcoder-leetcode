# 遍历S，判断元素是否在J中，是则累加
class Solution(object):
    def numJewelsInStones(self, J, S):
        count = 0
        for i in S:
            if i in J:
                count += 1
        return count