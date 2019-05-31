class Solution(object):
    def numMovesStones(self, a, b, c):
        a, b, c = sorted([a, b, c])
        if a+1==b and b+1==c:
            return [0, 0]
        if a+1==b or a+2==b or b+1==c or b+2==c:
            return [1, c-a-2]
        return [2, c-a-2]