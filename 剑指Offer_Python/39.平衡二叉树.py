# 平衡二叉树：二叉树的每个节点的左子树和右子树的深度差不大于1
class Solution:
    # 判断结点的左右子树深度差是否大于1
    def IsBalanced_Solution(self, pRoot):
        if not pRoot:
            return True
        if abs(self.TreeDepth(pRoot.left) - self.TreeDepth(pRoot.right)) > 1:
            return False
        return self.IsBalanced_Solution(pRoot.left) and self.IsBalanced_Solution(pRoot.right)

    # 求结点的左右子树的最大深度
    def TreeDepth(self, pRoot):
        if not pRoot:
            return 0
        return max(self.TreeDepth(pRoot.left), self.TreeDepth(pRoot.right)) + 1