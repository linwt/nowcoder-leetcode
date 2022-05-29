class Solution(object):
    def widthOfBinaryTree(self, root):
        # 结点与对应满二叉树的位置
        q = [(root, 1)]
        res = 0
        while q:
            # 每层最后一个结点的位置减去第一个结点的位置再加1得到宽度
            width = q[-1][1] - q[0][1] + 1
            res = max(width, res)
            # 弹出当前层结点，添加下一层结点
            for _ in range(len(q)):
                n, c = q.pop(0)
                if n.left:
                    q.append((n.left, c*2))
                if n.right:
                    q.append((n.right, c*2+1))
        return res