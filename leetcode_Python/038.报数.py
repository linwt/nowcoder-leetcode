class Solution(object):
    def countAndSay(self, n):
        res = '1'
        for i in range(n-1):
            res = ''.join([str(len(list(group))) + key for key, group in itertools.groupby(res)])
        return res