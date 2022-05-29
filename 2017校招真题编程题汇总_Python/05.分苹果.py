# 可分条件：平均为整数，比平均多的部分可被2整除，且整除结果就是移动次数
n = int(raw_input())
s = [int(i) for i in raw_input().split()]
if sum(s)%len(s)!=0:
    print(-1)
else:
    count = 0
    avg = sum(s)/len(s)
    for i in s:
        if i > avg:
            if (i-avg)%2==0:
                count += (i-avg)/2
            else:
                count = -1
                break
    print(count)