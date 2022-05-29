class Solution(object):
    def numFriendRequests(self, ages):
        count = [0]*121
        for age in ages:
            count[age] += 1
        res = 0
        for ageB in range(1, 121):
            for ageA in range(ageB, 121):
                if (ageB <= 0.5*ageA+7) or (ageB > ageA) or (ageB > 100 and ageA < 100):
                    continue
                res += count[ageA] * count[ageB]
                if ageA == ageB:
                    res -= count[ageA]
        return res