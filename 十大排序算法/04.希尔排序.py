#  把元素按下标的一定增量分组，对每组使用直接插入排序算法排序
def shell_sort(nums):
    n = len(nums)
    gap = n // 2
    while gap > 0:
        for i in range(gap, n):
            while i >= gap and nums[i] < nums[i-gap]:
                nums[i], nums[i-gap] = nums[i-gap], nums[i]
                i -= gap
        gap //= 2
    return nums


if __name__ == '__main__':
    nums = [2, 1, 6, 7, 9, 5, 0, 4, 3, 8]
    print(shell_sort(nums))