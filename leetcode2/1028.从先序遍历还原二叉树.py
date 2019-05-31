class Solution(object):
    def recoverFromPreorder(self, S):
        # 遍历字符串，记录结点值和对应层数
        layer, num, queue = 0, '', []
        for char in S:
            if char == '-':
                if num:
                    queue.append((num, layer))
                    num, layer = '', 0
                layer += 1
            else:
                num += char
        if num:
            queue.append((num, layer))

        head = TreeNode(None)
        # 存放已还原的结点和层数
        stack = [(head, -1)]
        for num, layer in queue:
            # 层数小于等于最后一个已还原结点时，弹出已还原结点直到其父节点
            while layer <= stack[-1][1]:
                stack.pop()
            node = TreeNode(num)
            parent = stack[-1][0]
            stack.append((node, layer))
            # 左孩子优先
            if parent.left:
                parent.right = node
            else:
                parent.left = node
        return head.left