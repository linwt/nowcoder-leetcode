# 从根节点开始，若根节点在给定范围左侧，那么他和他的左子树完全裁剪；
# 若根节点在给定范围右侧，那么他和他的右子树完全裁剪；
# 若根节点在给定范围内，不用裁剪，按照递归分别推出他左右子树的裁剪结果。
class Solution(object):
    def trimBST(self, root, L, R):
        if not root:
            return
        elif root.val < L:
            return self.trimBST(root.right, L, R)
        elif root.val > R:
            return self.trimBST(root.left, L, R)
        else:
            root.left = self.trimBST(root.left, L, R)
            root.right = self.trimBST(root.right, L, R)
        return root