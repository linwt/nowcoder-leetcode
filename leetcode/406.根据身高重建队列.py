# 先按升高降序排序，身高相同则按k升序排序。再以k为索引插入排序
class Solution(object):
    def reconstructQueue(self, people):
        people.sort(key=lambda x:(-x[0], x[1]))
        res = []
        for p in people:
            res.insert(p[1], p)
        return res