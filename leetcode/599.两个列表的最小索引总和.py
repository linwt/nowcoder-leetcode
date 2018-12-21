# 先将共同字符串的索引和存入字典，再找出索引和最小的字符串
class Solution(object):
    def findRestaurant(self, list1, list2):
        d = {}
        for l in list1:
            if l in list2:
                d[l] = list1.index(l) + list2.index(l)
        return [key for key in d if d[key]==min(d.values())]