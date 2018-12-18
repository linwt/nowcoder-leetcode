class Solution(object):
    def intToRoman(self, num):
        res = ''
        d = {'M': 1000, 'CM': 900, 'D': 500, 'CD': 400, 'C': 100, 'XC': 90,
             'L': 50, 'XL': 40, 'X': 10, 'IX': 9, 'V': 5, 'IV': 4, 'I': 1}
        # 字典无序，需要先排序，再逆转
        for char, val in sorted(d.items(), key = lambda x: x[1])[::-1]:
            while num >= val:
                res += char
                num -= val
        return res