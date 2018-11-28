class Solution(object):
    def sumOfDistancesInTree(self, N, edges):
        d = collections.defaultdict(set)
        for s,t in edges:
            d[s].add(t)
            d[t].add(s)

        count = [1]*N
        res = [0]*N

        # 计算孩子到根的距离
        def dfs(root, vis):
            vis.add(root)
            for i in d[root]:
                if i not in vis:
                    dfs(i, vis)
                    # res[i]是用i作为根，所有孩子到i的距离之和
                    count[root] += count[i]
                    res[root] += res[i] + count[i]

        # 计算根到孩子的距离
        def dfs2(root, vis):
            vis.add(root)
            for i in d[root]:
                if i not in vis:
                    res[i] = res[root] - count[i] + N-count[i]
                    dfs2(i, vis)

        dfs(0, set())
        dfs2(0, set())
        return res