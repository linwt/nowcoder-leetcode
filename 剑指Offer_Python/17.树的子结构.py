# 递归：寻找相同结点需要递归，判断是否为子结构也需要递归

class Solution:
    # 方法作用：A中寻找与B根结点相同的节点，并判断B是否为A的子结构
    def HasSubtree(self, pRoot1, pRoot2):
        # 终止条件：A或B的根节点为空
        if not pRoot1 or not pRoot2:
            # 处理方法
            return False
        # 提取重复逻辑
        return self.is_subtree(pRoot1, pRoot2) or self.HasSubtree(pRoot1.left, pRoot2) or self.HasSubtree(pRoot1.right, pRoot2)

    # 方法作用：判断两个结点是否相同
    def is_subtree(self, A, B):
        # 终止条件：B先遍历完则返回ture
        if not B:
            return True
        # 终止条件：A先遍历完或AB的值不相等，说明不是子结构
        if not A or A.val != B.val:
            return False
        # 提取重复逻辑。否则两值相等，再递归判断左右子树的值
        return self.is_subtree(A.left, B.left) and self.is_subtree(A.right, B.right)