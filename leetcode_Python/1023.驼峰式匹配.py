class Solution(object):
    def camelMatch(self, queries, pattern):
        res = []
        l = len(pattern)
        for q in queries:
            i = 0
            flag = True
            for char in q:
                # 与模板字符匹配
                if i < l and char == pattern[i]:
                    i += 1
                # 与模板字符不匹配，且为大写字母，则待查项与模式串不匹配
                elif 'A' <= char <= 'Z':
                    flag = False
                    break
            # 模板没有全部匹配
            if i < l:
                flag = False
            res.append(flag)
        return res