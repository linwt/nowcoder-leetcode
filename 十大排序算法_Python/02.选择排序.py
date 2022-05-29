# 外循环控制循环次数，内循环查找出最小元素，并与第一个元素交换位置
# 除去第一个元素，对剩余元素重复以上循环
def select_sort(nums):
    for i in range(len(nums)-1):
        min_index = i
        for j in range(i+1, len(nums)):
            if nums[j] < nums[min_index]:
                min_index = j
        nums[min_index], nums[i] = nums[i], nums[min_index]
    return nums


if __name__ == '__main__':
    nums = [2, 1, 6, 7, 9, 5, 0, 4, 3, 8]
    print(select_sort(nums))