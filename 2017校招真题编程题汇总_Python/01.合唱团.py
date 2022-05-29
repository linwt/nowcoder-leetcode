# 动态规划
n = int(raw_input())
stu = map(int, raw_input().split())
k, d = map(int, raw_input().split())
res_max = [[0]*k for _ in range(n)]
res_min = [[0]*k for _ in range(n)]
for i in range(n):
    res_max[i][0] = stu[i]
    res_min[i][0] = stu[i]
for j in range(1, k):
    for i in range(n):
        for p in range(i+1, min(i+d+1, n)):
            res_max[p][j] = max(max(res_min[i][j-1]*stu[p], res_max[i][j-1]*stu[p]), res_max[p][j])
            res_min[p][j] = min(min(res_min[i][j-1]*stu[p], res_max[i][j-1]*stu[p]), res_min[p][j])
print(max(res_max[i][k-1] for i in range(n)))