'''
题意可以理解为：有没有可以通行的点，但牛牛到不了（输出-1）。如果没有这样的点，牛牛可能花费最多步数是多少。
思路：计算地图里，每个点的最短到达步数。找到到不了的点，或者最短步数里步数最多的点。
1. 创建3个矩阵，size都是n*m的。分别是地图矩阵 mm、步数矩阵 sm、到达矩阵 am。
2. 设置初始点为第一轮的探索点，更新 sm 里初始点的最短步数为0，更新 am 里初始点的到达状态为1。
3. 找到从探索点一步能到达的点，且这些点可以通行并没有到达过。更新这些点的 sm 和 am。并将这些点当作下一轮的探索点。
4. 循环第3步，直到没有新一轮的探索点了。
5. 从 sm 中可以得到正确答案。
'''

#coding=utf-8
n, m = map(int, raw_input().split())
map_matrix = [raw_input() for _ in range(n)]            # 地图矩阵，'.' 表示可以通行的位置，'X' 表示不可通行的障碍
x0, y0 = map(int, raw_input().split())                  # 开始点的坐标
k = int(raw_input())                                    # 共有k种行走方式
alternative_steps = [map(int, raw_input().split()) for _ in range(k)]  # 可以选择的行走方式
step_matrix = [[-1]*m for _ in range(n)]                # 步数矩阵，记录到达该点使用最短步数。初始是-1
arrived_matrix = [[0]*m for _ in range(n)]              # 到达矩阵，记录是否已经到达过该点。初始是0，表示没有到达过
arrived_matrix[x0][y0] = 1                              # 初始点修改为已到达的点
step_matrix[x0][y0] = 0                                 # 初始点到达步数为0
current_points = [[x0, y0]]                             # 第一轮所在的探索点（多个）
while len(current_points) > 0:                          # 如果当前探索点是0个，结束循环。
    next_points = []                                    # 下一轮的探索点（多个）
    for point in current_points:
        x, y = point[0], point[1]                       # 一个探索点
        for step in alternative_steps:
            x_, y_ = x + step[0], y + step[1]           # 该探索点一步能到达的点
            # 检查是否越界，该点是否可以通行，或者已经达到过
            if x_ < 0 or x_ >= n or y_ < 0 or y_ >= m or map_matrix[x_][y_] != '.' or arrived_matrix[x_][y_] == 1:
                continue
            step_matrix[x_][y_] = step_matrix[x][y] + 1     # 更新步数矩阵
            arrived_matrix[x_][y_] = 1                      # 更新到达矩阵
            next_points.append([x_, y_])                    # 该点添加到下一轮探索点里
    current_points = next_points
# 从步数矩阵中找到到不了的点，或者最大的步数，然后输出
try:
    max_step = 0
    for i in range(n):
        for j in range(m):
            step = step_matrix[i][j]
            if step==-1 and map_matrix[i][j]=='.':
                raise Exception
            if step > max_step:
                max_step = step
    print(max_step)
except:
    print(-1)