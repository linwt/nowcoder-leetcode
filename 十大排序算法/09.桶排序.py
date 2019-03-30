# 获取数组最大值和最小值并构建在该范围的数组长度，数组记录元素出现的个数，最后遍历数组获取对应个数的元素
def bucket_sort(nums):
    max_num, min_num = max(nums), min(nums)
    count = [0 for _ in range(min_num, max_num+1)]
    res = []
    for num in nums:
        count[num-min_num] += 1
    for index in range(len(count)):
        if count[index] != 0:
            res += [index+min_num] * count[index]
    return res


if __name__ == '__main__':
    nums = [2, 1, 8, 9, 9, 5, 9, 4, 4, 8]
    print(bucket_sort(nums))