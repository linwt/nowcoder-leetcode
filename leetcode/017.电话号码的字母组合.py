# 回溯
class Solution(object):
    def letterCombinations(self, digits):
        if not digits:
            return []
        d = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        def combine(s, digits):
            # 递归终止条件
            if not digits:
                res.append(s)
            else:
                for char in d[digits[0]]:
                    combine(s + char, digits[1:])
        res = []
        combine('', digits)
        return res


# 使用变量
class Solution2(object):
    def letterCombinations(self, digits):
        if not digits:
            return []
        d = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        res = ['']
        for i in range(len(digits)):
            res = [x + y for x in res for y in d[digits[i]]]
        return res

# 递归
class Solution3(object):
    def letterCombinations(self, digits):
        if not digits:
            return []
        d = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        if len(digits) == 1:
            return [x for x in d[digits[0]]]
        return [x + y for x in d[digits[0]] for y in self.letterCombinations(digits[1:])]


# 动态规划
class Solution4(object):
    def letterCombinations(self, digits):
        if not digits:
            return []
        d = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        n = len(digits)
        dp = [[] for _ in range(n)]
        dp[0] = [x for x in d[digits[0]]]
        for i in range(1, n):
            dp[i] = [x + y for x in dp[i - 1] for y in d[digits[i]]]
        return dp[-1]