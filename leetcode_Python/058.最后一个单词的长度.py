class Solution(object):
    def lengthOfLastWord(self, s):
        s = s.split()
        return len(s[-1]) if s else 0