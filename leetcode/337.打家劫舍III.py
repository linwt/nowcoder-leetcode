class Solution(object):
    def rob(self, root):

        def dfs(root):
            if not root:
                return (0, 0)
            l_rob, l_norob = dfs(root.left)
            r_rob, r_norob = dfs(root.right)
            cur_rob = l_norob + r_norob + root.val
            # 当前结点不偷时，需要再判断子结点偷与不偷哪个更大
            cur_norob = max(l_rob, l_norob) + max(r_rob, r_norob)
            return (cur_rob, cur_norob)

        return max(dfs(root))

##################### 递归思路 #######################
# 方法作用极简化：先判断无结点和1个结点的情况
# 方法作用描述：参数给一个结点，返回该结点偷与不偷的值
# 递归：由于左右子树需要同样操作，使用递归。
class Solution(object):
    def rob(self, root):

        def dfs(root):
            if not root:
                return (0, 0)
            cur_rob = root.val
            cur_norob = 0
            return (cur_rob, cur_norob)

        return max(dfs(root))