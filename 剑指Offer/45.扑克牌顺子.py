class Solution:
    def IsContinuous(self, numbers):
        if len(numbers) != 5:
            return False
        numbers.sort()
        while 0 in numbers:
            numbers.remove(0)
        for i,v in enumerate(numbers):
            # 牌重复
            if v in numbers[i+1:]:
                return False
        # 顺子区间在5以内
        if numbers[-1]-numbers[0] < 5:
            return True