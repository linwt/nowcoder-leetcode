n = int(raw_input())
nums = list(map(int, raw_input().split()))
max_sum = cur_sum = 0
if max(nums)<0:
    nums.sort()
    print(nums[-1])
else:
    for i in nums:
        cur_sum += i
        if cur_sum > max_sum:
            max_sum = cur_sum
        # 小于0说明前面求和负大于正，重新设置起点
        if cur_sum < 0:
            cur_sum = 0
    print(max_sum)