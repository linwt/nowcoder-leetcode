# 外循环控制循环次数，内循环控制左右元素两两比较，若第一个大于第二个则交换位置，最终最大的元素会放在最右边
# 除去最后一个元素，对剩余元素重复以上循环
def bubble_sort(nums):
    for i in range(1, len(nums)):
        for j in range(len(nums)-i):
            if nums[j] > nums[j+1]:
                nums[j], nums[j+1] = nums[j+1], nums[j]
    return nums


if __name__ == '__main__':
    nums = [2, 1, 6, 7, 9, 5, 0, 4, 3, 8]
    print(bubble_sort(nums))
