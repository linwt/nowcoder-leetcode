# 数组中比目标字符大的则直接返回，否则返回第一个字符
class Solution(object):
    def nextGreatestLetter(self, letters, target):
        for letter in letters:
            if letter > target:
                return letter
        return letters[0]