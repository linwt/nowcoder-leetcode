# 寻找左子树的最左边的高度和右子树的最右边的高度，如果相同则为满二叉树，高度为2^h-1， 否则递归左子树和右子树
# 方法作用极简化：求满二叉树的结点个数。若树不是满二叉树，则递归判断左右子树是否为满二叉树并求结点个数
class Solution(object):
    def countNodes(self, root):
        if not root:
            return 0
        p, q = root, root
        lhigh = rhigh = 0
        while p:
            p = p.left
            lhigh += 1
        while q:
            q = q.right
            rhigh += 1
        if lhigh == rhigh:
            return int(math.pow(2, lhigh)-1)
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)