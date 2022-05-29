class Solution(object):
    def detectCapitalUse(self, word):
        big = small = 0
        for s in word:
            if 'A' <= s <= 'Z':
                big += 1
            if 'a' <= s <= 'z':
                small += 1
        if big==0 or small==0:
            return True
        elif small and big==1 and 'A' <= word[0] <= 'Z':
            return True
        else:
            return False