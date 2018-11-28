# 层次遍历得到每一层的结点，每个结点的next指针指向列表的下一个结点
class Solution:
    def connect(self, root):
        if not root:
            return
        cur_level, next_level = [root], []
        while cur_level:
            for node in cur_level:
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            for i in range(len(cur_level)-1):
                cur_level[i].next = cur_level[i+1]
            cur_level, next_level = next_level, []