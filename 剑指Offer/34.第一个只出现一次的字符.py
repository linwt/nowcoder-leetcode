class Solution:
    def FirstNotRepeatingChar(self, s):
        if not s:
            return -1
        for index, value in enumerate(s):
            if s.count(value) == 1:
                return index