class Solution(object):
    def combinationSum(self, candidates, target):
        # 参数：输出数组，目标数
        def find(output, target):
            # 终止条件，将满足条件的结果添加到全局数组，返回空结束当前递归
            if target == 0 and sorted(output) not in res:
                res.append(sorted(output))
                return
            # 遍历每个元素处理判断
            for candidate in candidates:
                new_target = target - candidate
                # 剪枝条件，新的目标数若≥0，则可在候选数组继续寻找下一元素
                if new_target >= 0:
                    # 输出数组和目标值动态更新，调用递归逐步产生结果，递归完成后回溯，继续搜索下一个结果
                    find(output + [candidate], new_target)

        res = []
        find([], target)
        return res