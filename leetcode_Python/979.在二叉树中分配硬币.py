# 从后序遍历的第一个叶子节点开始，假设自己有x个金币，剩余x-1个金币都还给父节点，x-1可能为负数、0、正数
# x-1 < 0 说明不够金币，需要从父节点获得，因此子节点有|x-1|个入方向的操作，次数加上|x-1|
# x-1 == 0 说明刚好，无需与父节点有金币的交换，次数加0
# x-1 > 0 说明有多余的金币，需要交给父节点，因此子节点有x-1个出方向的操作，次数加上|x-1|
class Solution(object):
    def distributeCoins(self, root):
        res = [0]

        def postOrder(root):
            if not root:
                return 0
            left = postOrder(root.left)
            right = postOrder(root.right)
            diff = root.val + left + right - 1
            res[0] += abs(diff)
            return diff

        postOrder(root)
        return res[0]

