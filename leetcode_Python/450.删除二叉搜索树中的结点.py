# 如果key结点没有孩子或只有一个孩子，则将key结点指针指向空或指向孩子，即删除了key结点
# 如果key结点有两个孩子，则用其右子树中的最小值替换掉key结点，然后将右子树中的这一最小值递归地删除
class Solution(object):
    def deleteNode(self, root, key):
        # 找树的最小值
        def findmin(root):
            while root.left:
                root = root.left
            return root.val

        if not root:
            return
        elif key < root.val:
            # 递归，在左子树中删除key结点，然后返回左子树新的根给根的左孩子
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            # 递归，在右子树中删除key结点，然后返回右子树新的根给根的右孩子
            root.right = self.deleteNode(root.right, key)
        # 找到key结点
        else:
            # 有左右孩子，用其右子树中的最小值替换掉key结点
            if root.left and root.right:
                minNum = findmin(root.right)
                root.val = minNum
                # 在右子树中删除最小值结点，然后返回右子树新的根给右孩子
                root.right = self.deleteNode(root.right, minNum)
            elif root.left:
                root = root.left
            else:
                # 可能有右孩子，也可能为空
                root = root.right
        return root

################################### 递归思路 #############################
# 方法作用极简化：先去掉递归的部分，再判断 无/1/2/3个结点的情况
# 所以deleteNode方法的作用是，以key结点为根的树，将根指针指向左孩子或右孩子或空，即删除了key结点，然后返回新的根
class Solution(object):
    def deleteNode(self, root, key):
        if not root:
            return
        else:
            if root.left:
                root = root.left
            else:
                root = root.right
        return root