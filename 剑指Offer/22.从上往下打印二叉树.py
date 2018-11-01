# res存放每一层结点的值，cur存放当前层和下一层结点
class Solution:
    def PrintFromTopToBottom(self, root):
        if not root:
            return []
        res = []
        cur = [root]
        while cur:
            for i in cur:
                t = cur.pop(0)
                res.append(t.val)
                if t.left:
                    cur.append(t.left)
                if t.right:
                    cur.append(t.right)
        return res