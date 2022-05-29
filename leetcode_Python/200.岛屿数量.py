# 深度优先搜索。原数组修改标志
class Solution(object):
    def numIslands(self, grid):
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        d = ((1, 0), (-1, 0), (0, 1), (0, -1))

        def dfs(x, y):
            # 位置合法且为陆地
            if 0 <= x < m and 0 <= y < n and int(grid[x][y]):
                # 更改为水
                grid[x][y] = '0'
                # 深度优先搜索，遍历四个方向
                for dx, dy in d:
                    dfs(x + dx, y + dy)

        count = 0
        for i in range(m):
            for j in range(n):
                count += int(grid[i][j])
                # 让一个岛屿变成水
                dfs(i, j)

        return count


# 深度优先搜索。创建数组记录访问状态
class Solution2(object):
    def numIslands(self, grid):
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        visited = [[0]*n for _ in range(m)]
        d = ((1, 0), (-1, 0), (0, 1), (0, -1))

        def dfs(x, y):
            visited[x][y] = 1
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == '1' and visited[nx][ny] == 0:
                    dfs(nx, ny)

        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and visited[i][j] == 0:
                    count += 1
                    dfs(i, j)

        return count


# 深度优先搜索。简洁版
class Solution3(object):
    def numIslands(self, grid):
        def sink(x, y):
            if 0 <= x < len(grid) and 0 <= len(grid[0]) < y and int(grid[x][y]):
                grid[x][y] = '0'
                for dx, dy in zip((1, -1, 0, 0), (0, 0, 1, -1)):
                    sink(x + dx, y + dy)
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[0])))


# 广度优先遍历
class Solution4(object):
    def numIslands(self, grid):
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        d = ((1, 0), (-1, 0), (0, 1), (0, -1))

        count = 0
        for i in range(m):
            for j in range(n):
                if int(grid[i][j]):
                    count += 1
                    q = collections.deque()
                    q.appendleft((i, j))
                    while q:
                        x, y = q.pop()
                        if int(grid[x][y]):
                            grid[x][y] = '0'
                            for dx, dy in d:
                                nx, ny = x + dx, y + dy
                                if 0 <= nx < m and 0 <= ny < n and int(grid[nx][ny]):
                                    q.appendleft((nx, ny))

        return count


# 并查集
class Solution5(object):
    def numIslands(self, grid):
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        # 记录每个结点的父亲
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
            for j in range(n):
                if grid[i][j] == '1':
                    # 若字典有键(i, j)(1)，则其值为键(i, j)(1)对应的值；否则设置键(i, j)(1)的值为(i, j)(2)
                    d.setdefault((i, j), (i, j))
                    # 上边是陆地
                    if i > 0 and grid[i-1][j] == '1':
                        # 上边结点的根作为当前结点的根的父亲，即合并
                        d[find((i, j))] = find((i-1, j))
                    # 左边是陆地
                    if j > 0 and grid[i][j-1] == '1':
                        # 左边结点的根作为当前结点的根的父亲
                        d[find((i, j))] = find((i, j-1))

        return len(set([find(x) for x in d.keys()]))