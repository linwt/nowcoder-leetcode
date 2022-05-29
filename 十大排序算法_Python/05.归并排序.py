# 将数组分解最小，然后依次合并两个有序数组
# 合并思路：比较两个数组的最左边的数，取较小者，取了后相应的指针往右移一位。继续比较，直至一个数组为空，最后复制另一个数组的剩余部分
def merge_sort(nums):
    if len(nums) < 2:
        return nums
    left = merge_sort(nums[:len(nums)//2])
    right = merge_sort(nums[len(nums)//2:])
    return merge(left, right)


def merge(left, right):
    l = r = 0
    res = []
    while l < len(left) and r < len(right):
        if left[l] < right[r]:
            res.append(left[l])
            l += 1
        else:
            res.append(right[r])
            r += 1
    res += left[l:]
    res += right[r:]
    return res


if __name__ == '__main__':
    nums = [2, 1, 6, 7, 9, 5, 0, 4, 3, 8]
    print(merge_sort(nums))