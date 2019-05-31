# 深度优先搜索
class Solution(object):
    def findCircleNum(self, M):
        m = len(M[0])
        visited = [0 for _ in range(m)]
        count = 0

        # 参数动态更新：当前好友、已访问数组
        def dfs(i):
            # 当前好友状态置为已访问
            visited[i] = 1
            # 遍历所有人
            for j in range(m):
                # 若两人是朋友并且其朋友未访问过
                if M[i][j] == 1 and visited[j] == 0:
                    # 递归遍历朋友的朋友
                    dfs(j)

        # 遍历所有人
        for i in range(m):
            # 若当前好友未访问过
            if visited[i] == 0:
                # 则朋友圈个数加1
                count += 1
                # 深度优先搜索，递归遍历他的朋友
                dfs(i)

        return count


# 并查集
class Solution2:
    def findCircleNum(self, M):
        m = len(M)
        # 记录每个结点的父亲
        parent = [i for i in range(m)]

        # 查找
        def find(i):
            # 根结点的父亲是自己，找到根结点，即找到代表元
            if i == parent[i]:
                return i
            return find(parent[i])

        # 合并
        def union(i, j):
            # 找到各自的根结点
            root_i, root_j = find(i), find(j)
            # 将某一方根结点置为另一方根结点的父亲，即合并
            parent[root_j] = root_i

        for i in range(m):
            for j in range(i+1):
                if M[i][j]:
                    union(i,j)

        return len(set([find(i) for i in range(m)]))


# 并查集
class Solution3(object):
    def findCircleNum(self, M):
        m = len(M)
        # 用字典记录每个结点的父亲
        d = {}

        # 查找
        def find(x):
            # x的父亲不是自己，即不是根结点
            while d[x] != x:
                # 逐级往上找x的父亲的父亲
                x = d[d[x]]
            # 返回根结点
            return x

        for i in range(m):
            for j in range(i+1):
                if M[i][j] == 1:
                    # 若字典有键i(1)，则其值为键i(1)对应的值；否则设置键i(1)的值为i(2)
                    d.setdefault(i, i)
                    d.setdefault(j, j)
                    # 将某一方根结点置为另一方根结点的父亲，即合并
                    d[find(i)] = find(j)

        return len(set([find(x) for x in d]))