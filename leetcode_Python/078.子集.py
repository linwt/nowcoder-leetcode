# 递归
class Solution(object):
    def subsets(self, nums):
        # 终止条件，返回空集
        if not nums:
            return [[]]
        # 获取剩余数组的子集
        sub = self.subsets(nums[1:])
        # 将第一个元素添加到所有子集中构成新的子集
        return [([nums[0]] + s) for s in sub] + sub


# 迭代
class Solution2(object):
    def subsets(self, nums):
        # 初始化结果数组
        res = [[]]
        for num in nums:
            # 每次迭代将新的数添加到已有子集中构成新的子集
            res += [v+[num] for v in res]
        return res


# 回溯
class Solution3(object):
    def subsets(self, nums):

        def find(nums, index, output):
            # 每一个新的数组都是子集，可直接添加到全局数组
            res.append(output)
            # 遍历数组
            for i in range(index, len(nums)):
                # 通过索引控制可取数组元素
                find(nums, i + 1, output + [nums[i]])

        res = []
        find(nums, 0, [])
        return res


# 回溯
class Solution4(object):
    def subsets(self, nums):

        def find(nums, index, output, res):
            res.append(output)
            for i in range(index, len(nums)):
                # 先更新输出数组，递归回溯后再弹出新值，还原输出数组，搜索下一种情况
                output.append(nums[i])
                find(nums, i + 1, output, res)
                output.pop()

        res = []
        find(nums, 0, [], res)
        return res


# 回溯
class Solution5(object):
    def subsets(self, nums):
        def find(nums, output):
            res.append(output)
            for i in range(len(nums)):
                # 数值数组和输出数组元素动态更新
                find(nums[i+1:], output + [nums[i]])

        res = []
        find(nums, [])
        return res