# 逆向操作
class Solution(object):
    def deckRevealedIncreasing(self, deck):
        # 将原数组倒序排序
        deck.sort(reverse=True)
        res = []
        while deck:
            # 如果新数组有元素，则将最后一个元素移到首位
            if res:
                res = [res[-1]] + res[:-1]
            # 再插入新元素到首位
            res.insert(0, deck.pop(0))
        return res