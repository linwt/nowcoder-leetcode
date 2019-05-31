# 回溯
class Solution(object):
    def letterCasePermutation(self, S):
        # 两个数组分别存放最终结果和临时结果
        res, temp = [''], []
        for s in S:
            # 若为数字，则直接添加到每个字符串尾部
            if s.isdigit():
                for v in res:
                    temp.append(v + s)
            # 若为字母，则每个字符串分别添加该字母的小写和大写形式
            else:
                for v in res:
                    temp.append(v + s.lower())
                    temp.append(v + s.upper())
            # 将最新结果的临时数组赋给结果数组，临时数组清空
            res, temp = temp, []
        return res


# 递归
class Solution2(object):
    def letterCasePermutation(self, S):

        def permutation(s, i, res):
            if i >= len(s):
                return res
            temp = []
            for v in res:
                if s[i].isdigit():
                    temp.append(v + s[i])
                else:
                    temp.append(v + s[i].lower())
                    temp.append(v + s[i].upper())
            return permutation(s, i + 1, temp)

        return permutation(S, 0, [''])