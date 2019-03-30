def count_sort(nums):
    max_num, min_num = max(nums), min(nums)
    count = [0] * (max_num - min_num + 1)
    res = [0] * len(nums)
    # 记录每个元素出现次数
    for num in nums:
        count[num-min_num] += 1
    # 加上前一元素值，此时每个元素的含义是包括当前元素在内有多少个元素在桶里
    for i in range(1, len(count)):
        count[i] += count[i-1]
    # 获取每个元素在最终数组中对应位置索引并存入
    for num in nums:
        res[count[num-min_num]-1] = num
        count[num-min_num] -= 1
    return res


if __name__ == '__main__':
    nums = [2, 1, 8, 9, 9, 5, 9, 4, 4, 8]
    print(count_sort(nums))