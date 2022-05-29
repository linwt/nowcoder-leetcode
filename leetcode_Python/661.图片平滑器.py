# 遍历每个元素，将其周围的元素累加取平均，然后添加到该行的新数组中，一行遍历完成后将改行结果添加到矩阵数组中
class Solution(object):
    def imageSmoother(self, M):
        dx = [0, 0, 1, 1, 1, -1, -1, -1]
        dy = [1, -1, 1, 0, -1, 1, 0, -1]
        res = []
        row, col = len(M), len(M[0])
        for i in range(row):
            cur = []
            for j in range(col):
                sum = M[i][j]
                count = 1
                for x, y in zip(dx, dy):
                    if 0 <= i+x < row and 0 <= j+y < col :
                        sum += M[i+x][j+y]
                        count += 1
                cur.append(sum/count)
            res.append(cur)
        return res