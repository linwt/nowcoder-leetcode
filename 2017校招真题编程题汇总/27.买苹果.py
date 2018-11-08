# 动态规划
n = int(raw_input())
count = 100
# 买8的袋数
for i in range(n/8+1):
    num = n-i*8
    # 余下买6
    if num%6==0:
        count = min(count, i+num/6)
print -1 if count==100 else count


# 数字分析
# 偶数个苹果数对8取模，其结果只可能为0,2,4,6
# 若余数为0，恰好用于买每袋8个
# 若余数为6，不需回溯，直接再购买一袋6个              n/8+1
# 若余数为4，只需回溯1次即可，因为8+4=12, 12%6=0     (n/8-1)+2 = n/8+1
# 若余数为2，只需回溯2次即可，因为8+8+2=18, 18%6=0   (n/8-2)+3 = n/8+1
n = int(raw_input())
if n%8==0:
    print(n/8)
elif n%8 in [2,4,6]:
    print(n/8+1)
else:
    print(-1)