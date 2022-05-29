def radix_sort(nums):
    # 最大数字长度作为排序次数
    for k in range(len(str(max(nums)))):
        # 数字0-9建立10个桶
        buckets = [[] for _ in range(10)]
        # 对每个元素从低位到高位获取对应数字，放入对应的桶
        for num in nums:
            buckets[num//(10**k) % 10].append(num)
        nums = [num for bucket in buckets for num in bucket]
    return nums


if __name__ == '__main__':
    nums = [21, 111, 84, 91, 454, 52, 312, 421, 4, 8]
    print(radix_sort(nums))