# coding=utf-8
def isValid(matrix,n,m,p,x,y,visited):
    isvisit = (x*m+y in visited)                        # 是否已访问
    isvalid = (0<=x<n and 0<=y<m and matrix[x][y]==1)   # 是否通路
    hasp = (p>=0)                                       # 是否有剩余能量值
    return not isvisit and isvalid and hasp             # 是否可走

def getPath(matrix, n, m, p, x, y, visited, path):
    if (x,y) == (0,m-1):
        return True
    # 向右，向上，向左，向下 (贪心思想，尽可能以最小的消耗靠近右上角的终点)
    nextpos=[(x,y+1,p-1),(x-1,y,p-3),(x,y-1,p-1),(x+1,y,p)]
    for nextx,nexty,nextp in nextpos:
        if isValid(matrix, n, m, nextp, nextx, nexty, visited):
            path.append([nextx,nexty])
            visited.add(nextx*m + nexty)
            # 由该点延伸出来的路径是否能到达终点，如果成功，则该路径是体力消耗最小的路径
            if getPath(matrix, n, m, nextp, nextx, nexty, visited, path):
                return True
            # 如果不成功，移除该路径，继续判断下一路径
            path.pop(-1)
            visited.remove(nextx*m + nexty)
    return False

if __name__ == '__main__':
    n, m, p = map(int, raw_input().split())
    matrix = [map(int, raw_input().split()) for _ in range(n)]
    visited = set()
    path = [[0,0]]
    if getPath(matrix, n, m, p, 0, 0, visited, path):
        print(','.join(map(str, path)).replace(' ', ''))
    else:
        print('Can not escape!')