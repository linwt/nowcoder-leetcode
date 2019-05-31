class Solution(object):
    def countArrangement(self, N):
        # 参数：整数数组，输出数组
        def butty(nums, output):
            # 终止条件，若输出数组满足条件则排列个数加1，返回空结束当前递归
            if len(output) == N:
                self.res += 1
                return
            # 遍历，递归，使得整数数组中每个元素都有机会成为输出数组的下一个元素
            for i in range(len(nums)):
                # 剪枝条件
                if nums[i] % (len(output) + 1) == 0 or (len(output) + 1) % nums[i] == 0:
                    # 整数数组和输出数组元素动态更新，调用递归逐步产生结果，递归完成后回溯，继续搜索下一个结果
                    butty(nums[:i] + nums[i+1:], output + [nums[i]])

        self.res = 0
        nums = list(range(1, N+1))
        butty(nums, [])
        return self.res