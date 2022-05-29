class Solution(object):
    def hasGroupsSizeX(self, deck):
        d = collections.Counter(deck)
        min_v = min(d.values())
        # 元素最小次数小于2为False
        if min_v < 2:
            return False
        # 求最大公约数
        def gcd(a, b):
            if a % b == 0:
                return b
            return gcd(b, a%b)
        # 求每个元素的次数与最小次数的最大公约数，小于2为False
        for v in d.values():
            if gcd(v, min_v) < 2:
                return False
        return True