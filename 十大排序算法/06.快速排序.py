# 先在数组中挑出一个“基准”元素，比它小的放左边，比它大的放右边

# 递归，逐一赋值形式
def quick_sort(nums):
    l, r = 0, len(nums)-1
    # 数组为空或只有一个元素
    if l >= r:
        return nums
    key = nums[l]
    while l < r:
        while l < r and nums[r] >= key:
            r -= 1
        nums[l] = nums[r]
        while l < r and nums[l] <= key:
            l += 1
        nums[r] = nums[l]
    nums[l] = key
    l_nums = quick_sort(nums[:l])
    r_nums = quick_sort(nums[l+1:])
    return l_nums + [key] + r_nums


# 递归，两者交换形式
def quick_sort(nums):
    l, r = 0, len(nums)-1
    if l >= r:
        return nums
    p = l
    while l < r:
        while l < r and nums[r] >= nums[p]:
            r -= 1
        while l < r and nums[l] <= nums[p]:
            l += 1
        nums[r], nums[l] = nums[l], nums[r]
    nums[l], nums[p] = nums[p], nums[l]
    l_nums = quick_sort(nums[:l])
    r_nums = quick_sort(nums[l+1:])
    return l_nums + [nums[l]] + r_nums


# 非递归，栈实现
def quick_sort(nums):
    if len(nums) < 2:
        return nums
    stack = []
    stack.append(0)
    stack.append(len(nums)-1)
    while stack:
        l = stack.pop(0)
        r = stack.pop(0)
        index = partition(nums, l, r)
        if l < index:
            stack.append(l)
            stack.append(index-1)
        if r > index:
            stack.append(index+1)
            stack.append(r)
    return nums
    
def partition(nums, l, r):
    p = l
    while l < r:
        while l < r and nums[r] >= nums[p]:
            r -= 1
        while l < r and nums[l] < nums[p]:
            l += 1
        nums[l], nums[r] = nums[r], nums[l]
    nums[p], nums[l] = nums[l], nums[p]
    return l


if __name__ == '__main__':
    nums = [2, 1, 6, 7, 9, 5, 0, 4, 3, 8]
    print(quick_sort(nums))
