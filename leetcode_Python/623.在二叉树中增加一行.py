class Solution(object):
    def addOneRow(self, root, v, d):
        if d == 1:
            vnode = TreeNode(v)
            vnode.left = root
            return vnode

        queue = [(root, 1)]
        # 将d-1层的结点添加到queue中
        while queue:
            (node, depth) = queue.pop(0)
            if depth == d-1:
                queue.insert(0, (node, depth))
                break
            if node.left:
                queue.append((node.left, depth + 1))
            if node.right:
                queue.append((node.right, depth + 1))
        # 增加结点
        for (node, depth) in queue:
            l = node.left
            vnode = TreeNode(v)
            node.left = vnode
            vnode.left = l

            r = node.right
            vnode = TreeNode(v)
            node.right = vnode
            vnode.right = r

        return root