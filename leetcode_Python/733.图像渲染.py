class Solution(object):
    def floodFill(self, image, sr, sc, newColor):
        d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m, n, oldColor = len(image), len(image[0]), image[sr][sc]

        # 新值等于就值则返回原图像，避免无限搜索
        if newColor == oldColor:
            return image

        # 将符合条件的位置赋新值，再搜索该位置的四个方向是否符合
        def dfs(x, y):
            image[x][y] = newColor
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and image[nx][ny] == oldColor:
                    dfs(nx, ny)

        dfs(sr, sc)
        return image