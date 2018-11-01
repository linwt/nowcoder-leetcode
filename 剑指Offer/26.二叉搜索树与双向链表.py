# 方法一：根节点与叶结点连接
class Solution:
    def Convert(self, pRootOfTree):
        root = pRootOfTree
        if not root:
            return None
        if not root.left and not root.right:
            return root
        # 处理左子树
        left = self.Convert(root.left)
        # 连接根与左子树最深的右叶结点，即左子树最大的结点
        if left:
            while(left.right):
                left=left.right
            root.left = left
            left.right = root
        # 处理右子树
        right = self.Convert(root.right)
        # 连接根与右子树最深的左叶结点，即右子树最小的结点
        if right:
            while(right.left):
                right=right.left
            root.right = right
            right.left = root
        while(root.left):
            root = root.left
        return root

# 方法二：中序遍历得到排序的数组，相邻两个结点相互连接
class Solution:
    def __init__(self):
        self.array = []

    def Convert(self, pRootOfTree):
        if not pRootOfTree:
            return None
        self.mid_order(pRootOfTree)
        for i in range(len(self.array)-1):
            pre = self.array[i]
            after = self.array[i+1]
            pre.right = after
            after.left = pre
        return self.array[0]

    def mid_order(self, root):
        if not root:
            return None
        self.mid_order(root.left)
        self.array.append(root)
        self.mid_order(root.right)