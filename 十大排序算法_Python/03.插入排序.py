# 从左往右遍历每个元素，将遍历到的元素插入到该元素左边序列中，且位置在从右往左第一个小于等于该元素的元素右边
def insert_sort(nums):
    if len(nums) < 2:
        return nums
    for i in range(1, len(nums)):
        j = i
        while j > 0 and nums[j] < nums[j-1]:
            nums[j], nums[j-1] = nums[j-1], nums[j]
            j -= 1
    return nums


if __name__ == '__main__':
    nums = [2, 1, 6, 7, 9, 5, 0, 4, 3, 8]
    print(insert_sort(nums))