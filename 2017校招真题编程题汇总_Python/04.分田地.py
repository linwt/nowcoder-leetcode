n,m=map(int,raw_input().strip().split())
matrix=[map(int,list(raw_input().strip())) for _ in range(n)]
sum_values = [[0]*(m+1) for i in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, m + 1):
        sum_values[i][j] += sum_values[i - 1][j] + sum_values[i][j - 1] - sum_values[i - 1][j - 1] + matrix[i-1][j-1]

def calculate_sum(p1,p2):
    x1,y1=p1
    x2,y2=p2
    a1,a2=sum_values[x1 - 1][y1 - 1],sum_values[x1 - 1][y2]
    a3,a4=sum_values[x2][y1 - 1],sum_values[x2][y2]
    value=a4-a3-a2+a1
    return value

def check(mid):
    for j1 in range(1, m - 2):
        if calculate_sum((1,1),(n,j1)) < mid * 4: continue
        for j2 in range(j1 + 1, m - 1):
            if calculate_sum((1,j1+1),(n,j2)) < mid * 4: continue
            for j3 in range(j2 + 1, m):
                if calculate_sum((1,j2+1),(n,j3)) < mid * 4: continue
                if calculate_sum((1,j3+1),(n,m)) < mid * 4: continue
                pstart,row_count=1,0
                for pend in range(1, n + 1):
                    p1_list=[(pstart,1),(pstart,j1+1),(pstart,j2+1),(pstart,j3+1)]
                    p2_list=[(pend,j1),(pend,j2),(pend,j3),(pend,m)]
                    values=[calculate_sum(p1,p2) for p1,p2 in zip(p1_list,p2_list)]
                    if min(values) >= mid:
                        pstart=pend+1
                        row_count+=1
                        if row_count == 4:return True
    return False

l, r = 0, sum_values[n][m]
answer = 0
while l <= r:
    mid = (l + r) / 2
    if check(mid):
        l = mid + 1
        answer = mid
    else:
        r = mid - 1
print(answer)