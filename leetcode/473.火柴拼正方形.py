# 递归，贪心，深度优先，剪枝
# 每次尝试把每根火柴拼到4条边，全部拼完则可以组成正方形
class Solution(object):
    def makesquare(self, nums):
        # 不能组成正方形的情况：1.火柴总长度不是4的倍数  2.火柴数少于4  3.最长的火柴大于目标边长
        sums = sum(nums)
        if sums % 4 or len(nums) < 4:
            return False
        # 贪心，先排序可以节约回溯的次数
        nums.sort(reverse=True)
        side_len = sums / 4
        if nums[0] > side_len:
            return False

        def dfs(i, sides):
            """
            深度优先遍历
            :param i: 当前访问的火柴的位置
            :param sides: 当前4条边的长度
            :return:
            """
            # 递归终止条件，火柴全部拼完
            if i == len(nums):
                return True
            # 尝试把火柴拼到4条边中
            for j in range(4):
                # 当前边长加上新的火柴后长度小于等于目标边长。当前边长与前一边长相等时可跳过，以为如果前一边长失败，当前边长也会失败
                if sides[j] + nums[i] <= side_len and (j == 0 or sides[j] != sides[j - 1]):
                    # 放入当前火柴
                    sides[j] += nums[i]
                    # 放入下一根火柴
                    if dfs(i + 1, sides):
                        return True
                    # 放入失败，取出火柴准备放入下一条边
                    sides[j] -= nums[i]
            # 四条边都不能放火柴，回溯
            return False
        # 初始化边并从0开始放入
        return dfs(0, [0, 0, 0, 0])