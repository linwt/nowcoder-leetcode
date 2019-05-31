# root节点应该与左子树的最右结点最接近，或者右子树的最左结点
class Solution(object):
    def getMinimumDifference(self, root):
        self.res = 0x3f3f3f3f

        def getLeftMax(root):
            if not root:
                return 0x3f3f3f3f
            if not root.right:
                return root.val
            return getLeftMax(root.right)

        def getRightMin(root):
            if not root:
                return 0x3f3f3f3f
            if not root.left:
                return root.val
            return getRightMin(root.left)

        def getMin(root):
            if not root:
                return
            self.res = min(self.res, abs(root.val-getLeftMax(root.left)), abs(root.val-getRightMin(root.right)))
            getMin(root.left)
            getMin(root.right)

        getMin(root)
        return self.res