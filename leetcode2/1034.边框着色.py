# 连通分量边界：与至少一个非连通分量相邻的连通分量，或网格的首尾行列
class Solution(object):
    def colorBorder(self, grid, r0, c0, color):
        m = len(grid)
        n = len(grid[0])
        ret = [[0] * n for _ in range(m)]
        vis = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                ret[i][j] = grid[i][j]
        # 代表四个方向的分量
        ds = ((0,1),(1,0),(0,-1),(-1,0))
        t = grid[r0][c0]

        def dfs(i, j):
            # 判断当前网格是否已搜寻过
            if not vis[i][j]:
                vis[i][j] = True
                edge = False
                # 遍历四个方向的网格
                for di, dj in ds:
                    ni, nj = i+di, j+dj
                    # 某个方向在网格内
                    if 0<=ni<m and 0<=nj<n:
                        # 值相等则为连通分量，递归
                        if grid[ni][nj] == t:
                            dfs(ni,nj)
                        # 值不相等则当前网格是连通分量边界
                        else:
                            edge = True
                    # 某个方向不在网格内，则当前网格是网格边界
                    else:
                        edge = True
                # 遍历完四个方向后判断，若是边界则染色
                if edge:
                    ret[i][j] = color

        dfs(r0, c0)
        return ret
