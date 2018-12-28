# 先用字典存放员工id与员工信息，再将所求员工信息添加到数组中，将重要性累加，并加直系员工信息添加到数组中，循环处理数组
class Solution(object):
    def getImportance(self, employees, id):
        d = {e.id:e for e in employees}
        res = 0
        q = []
        q.append(d[id])
        while q:
            cur = q.pop(0)
            res += cur.importance
            for i in cur.subordinates:
                q.append(d[i])
        return res