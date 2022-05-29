# 拼接数组代表环形，遍历每个站点分别作为起始点。判断当前油量是否不小于到下一站的油耗，若不小于则计算到下一站补充后的总油量，
# 若小于则退出判断下一站点。若最终可绕环则返回该站点
class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        n = len(gas)
        gas += gas
        cost += cost
        for i in range(n):
            tank, count = gas[i], 0
            for j in range(i, i+n):
                if tank >= cost[j]:
                    tank = tank - cost[j] + gas[j+1]
                    count += 1
                else:
                    break
            if count == n:
                return i
        return -1