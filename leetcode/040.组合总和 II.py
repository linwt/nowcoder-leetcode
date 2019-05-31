class Solution(object):
    def combinationSum2(self, candidates, target):
        # 参数：候选数组，目标值，输出数组
        def find(candidates, target, output):
            if target == 0 and sorted(output) not in res:
                res.append(sorted(output))
                return
            for i in range(len(candidates)):
                new_target = target - candidates[i]
                if new_target >= 0:
                    # 候选数组每个数字在每个组合中只能使用一次，故递归时要去除已使用过的数字
                    find(candidates[:i] + candidates[i+1:], new_target, output + [candidates[i]])

        res = []
        find(candidates, target, [])
        return res