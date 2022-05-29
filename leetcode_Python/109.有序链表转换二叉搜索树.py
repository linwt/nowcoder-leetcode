# 将链表结点值存放在数组中，利用数组值递归构建二叉搜索树
class Solution(object):
    def sortedListToBST(self, head):
        res = []
        while head:
            res.append(head.val)
            head = head.next
        return self.buildTree(res)

    def buildTree(self, res):
        if not res:
            return
        # 每次取数组中间值作为结点，数组左右部分给左右子树
        root = TreeNode(res[len(res)/2])
        root.left = self.buildTree(res[:len(res)/2])
        root.right = self.buildTree(res[len(res)/2+1:])
        return root