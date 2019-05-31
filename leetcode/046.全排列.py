class Solution(object):
    def permute(self, nums):
        # 参数：输出数组，数组终止长度，原始数组
        def gen(output, n, nums):
            # 终止条件，将满足要求的独立结果添加到全局数组，返回空结束当前递归
            if len(output) == n:
                res.append(output)
                return
            # 遍历，判断，递归，使得原始数组中每个元素都有机会成为输出数组的下一个元素
            for num in nums:
                # 剪枝条件
                if num not in output:
                    # 输出数组元素动态更新，调用递归逐步产生结果，递归完成后回溯，继续搜索下一个结果
                    gen(output + [num], n, nums)

        # 全局数组，存放所有结果
        res = []
        # 调用递归函数，设置初值
        gen([], len(nums), nums)
        return res


class Solution2(object):
    def permute(self, nums):
        # 参数：输出数组，剩余数组
        def gen(output, nums):
            if not nums:
                res.append(output)
                return
            # 遍历，递归，使得剩余数组中每个元素都有机会成为输出数组的下一个元素
            for i in range(len(nums)):
                # 输出数组和剩余数组元素动态更新
                gen(output + [nums[i]], nums[:i] + nums[i+1:])

        res = []
        gen([], nums)
        return res