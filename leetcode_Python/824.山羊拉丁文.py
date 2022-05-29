class Solution(object):
    def toGoatLatin(self, S):
        res = []
        i = 1
        for s in S.split():
            if s[0] in 'aeiouAEIOU':
                s += 'ma'
            else:
                s = s[1:] + s[0] + 'ma'
            s += 'a'*i
            i += 1
            res.append(s)
        return ' '.join(res)