class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        # 左上角和右下角不是0
        if grid[0][0] or grid[-1][-1]:
            return -1
        n, queue, d = len(grid), [(0, 0, 2)], [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        if n <= 2:
            return n
        # 从起点开始，广度优先搜索
        for x, y, res in queue:
            # 搜索八个方向
            for dx, dy in d:
                nx, ny = x+dx, y+dy
                if 0 <= nx < n and 0 <= ny < n and not grid[nx][ny]:
                    # 有一条路径已经到达终点，返回路径长度
                    if nx == n-1 and ny == n-1:
                        return res
                    # 未到达终点，添加中间位置到队列
                    queue += [(nx, ny, res+1)]
                    # 搜索过的位置置1，防止重复搜索
                    grid[nx][ny] = 1
        # 没有路径到达终点
        return -1