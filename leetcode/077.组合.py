class Solution(object):
    def combine(self, n, k):
        # 参数：数值，输出数组
        def dfs(num, output):
            # 终止条件，将满足条件的结果添加到全局数组，返回空结束当前递归
            if len(output) == k:
                res.append(output)
                return
            # 剪枝条件
            elif num > n:
                return
            # 数值和输出数组元素动态更新，调用递归逐步产生结果，递归完成后回溯，继续搜索下一个结果
            dfs(num + 1, output + [num])
            dfs(num + 1, output)

        # 全局数组，存放所有结果
        res = []
        # 调用递归，设置初值
        dfs(1, [])
        return res