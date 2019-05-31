# 最多每个人需要一艘船，若最重和最轻若能组合则少一艘船
class Solution(object):
    def numRescueBoats(self, people, limit):
        l, r, res = 0, len(people)-1, len(people)
        people.sort()
        while l < r:
            if people[l] + people[r] <= limit:
                res -= 1
                l += 1
            r -= 1
        return res