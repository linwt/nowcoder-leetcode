class Solution(object):
    def findRedundantDirectedConnection(self, edges):
        def find(x, tree):
            if tree[x] == -1:
                return x
            root = find(tree[x], tree)
            tree[x] = root
            return root

        # 用 count 来计数不合法的边
        count = 0
        res = []
        tree = [-1] * (len(edges)+1)
        # 第一轮查找不合法的边（正序）
        for parent, child in edges:
            # child已经有parent 或 child的parent的parent（或者一直往上找）就是 child 本身
            if tree[child] != -1 or find(parent, tree) == child:
                res = [parent, child]
                count += 1
            else:
                tree[child] = parent
        # 如果只有一条不合法的边，直接返回
        if count == 1:
            return res

        # 要求返回最后一条边，重置 tree 并开始第二轮查找（逆序）
        tree = [-1] * (len(edges)+1)
        for parent, child in edges[::-1]:
            if tree[child] != -1 or find(parent, tree) == child:
                return [parent, child]
            else:
                tree[child] = parent
        return res