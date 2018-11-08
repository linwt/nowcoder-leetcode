# 比较首尾两个数，两个数不相等就进行加法，较小的数加上与其相邻的值
def getNum(item, left, right, head, tail, time):
    if head >= tail:
        return time
    elif left < right:
        head, time = head+1, time+1
        left += item[head]
    elif left > right:
        tail, time = tail-1, time+1
        right += item[tail]
    else:
        head, tail = head+1, tail-1
        left, right = item[head], item[tail]
    return getNum(item, left, right, head, tail, time)

n = int(raw_input())
item = map(int, raw_input().split())
print(getNum(item, item[0], item[-1], 0 ,n-1, 0))