# 寻根，当一条边让数组内构成循环，则删除该边
class Solution(object):
    def findRedundantConnection(self, edges):
        tree = [-1] * (len(edges) + 1)
        for edge in edges:
            a = self.findRoot(edge[0], tree)
            b = self.findRoot(edge[1], tree)
            if a != b:
                tree[a] = b
            else:
                return edge

    def findRoot(self, x, tree):
        if tree[x] == -1:
            return x
        root = self.findRoot(tree[x], tree)
        tree[x] = root
        return root