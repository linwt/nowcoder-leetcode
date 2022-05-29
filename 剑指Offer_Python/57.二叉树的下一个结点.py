# 中序遍历：左根右
class Solution:
    def GetNext(self, pNode):
        if not pNode:
            return None
        # 如果当前结点有右子树，那么下个结点就是右子树最左边的结点
        if pNode.right:
            pNext = pNode.right
            while pNext.left:
                pNext = pNext.left
            return pNext
        # 当前结点有下一个结点时
        while pNode.next:
            temp = pNode.next
            # 如果当前结点是父节点左孩子，那么父节点就是下一个节点
            if temp.left==pNode:
                return temp
            # 将父节点赋给当前结点，直到当前结点是其父节点的左孩子位置
            pNode = temp
        # 当前结点是尾结点
        return None