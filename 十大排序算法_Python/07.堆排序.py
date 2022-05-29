def heap_sort(nums):
    n = len(nums)
    # 最后一个有子节点的结点的索引
    first = n//2-1
    # 构造最大堆。逐个有子节点的结点进行调整
    for start in range(first, -1, -1):
        max_heapify(nums, start, n-1)
    # 将最大堆转化成有序数组
    for end in range(n-1, 0, -1):
        # 最后一个元素与第一个交换位置
        nums[end], nums[0] = nums[0], nums[end]
        # 交换后排除最后一个元素，重新调整成最大堆
        max_heapify(nums, 0, end-1)
    return nums


# 最大堆调整。子节点较大者与父节点交换
def max_heapify(nums, start, end):
    root = start
    # 父节点交换下来后判新子节点是否还可继续交换
    while True:
        child = 2*root+1
        if child > end:
            break
        # 获取较大子节点
        if child+1 <= end and nums[child] < nums[child+1]:
            child += 1
        # 较大子节点成为父节点
        if nums[child] > nums[root]:
            nums[child], nums[root] = nums[root], nums[child]
            root = child
        else:
            break

            
# 最小堆调整。子节点较小者与父节点交换
def min_heapify(nums, start, end):
    root = start
    while True:
        child = 2*root+1
        if child > end:
            break
        # 获取较小子节点
        if child+1 <= end and nums[child] > nums[child+1]:
            child += 1
        # 较小子节点成为父节点
        if nums[child] < nums[root]:
            nums[child], nums[root] = nums[root], nums[child]
            root = child
        else:
            break

            
if __name__ == '__main__':
    nums = [2, 1, 6, 7, 9, 5, 0, 4, 3, 8]
    print(heap_sort(nums))
