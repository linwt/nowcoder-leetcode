class Solution(object):
    def combinationSum3(self, k, n):
        # 参数：数值数组，输出数组
        def find(nums, output):
            # 终止条件
            if len(output) == k and sum(output) == n:
                res.append(output)
            # 剪枝条件，已有数和剩余数个数之和小于k
            elif len(nums) + len(output) < k:
                return
            else:
                # 遍历数值数组，使得每个元素都有机会成为输出数组的下一个元素
                for i in range(len(nums)):
                    # 数值数组和输出数组元素动态更新，调用递归逐步产生结果，递归完成后回溯，继续搜索下一个结果
                    find(nums[i+1:], output + [nums[i]])

        res = []
        nums = list(range(1, 10))
        find(nums, [])
        return res


class Solution2(object):
    def combinationSum3(self, k, n):
        # 参数：数值，输出数组
        def find(num, output):
            # 终止条件，将满足条件的结果添加到全局数组，返回空结束当前递归
            if len(output) == k and sum(output) == n:
                res.append(output)
                return
            # 剪枝条件，数值在1-9，返回空结束当前递归
            if num > 9:
                return
            # 数值和输出数组元素动态更新，调用递归逐步产生结果，递归完成后回溯，继续搜索下一个结果
            find(num + 1, output + [num])
            find(num + 1, output)

        res = []
        # 调用递归，设置初值
        find(1, [])
        return res