# 树状数组
class FenwickTree:
    def __init__(self, n):
        # 树状数组，从索引1开始存储，方便二进制计算
        self.C = [0 for _ in range(n+1)]

    def lowbit(self, x):
        # 等价于 x and (x xor (x-1))
        # -x 由 x 的二进制每一位取反再加1得到
        # 最终结果表示x二进制最低位1代表的值
        return x & -x

    # C[i]=A[i-2^k+1]+A[i-2^k+2]+...+A[i];  k表示i的二进制最低位连续0的个数
    # C[i]=A[i-lowbit(i)+1]+A[i-lowbit(i)+2]+...+A[i];
    # i+lowbit(i)可得到结点i的父节点，i-lowbit(i)可得到上一区间的尾结点
    def update(self, i, val):
        while i < len(self.C):
            # 当前结点值更新
            self.C[i] += val
            # 得到父节点
            i += self.lowbit(i)

    # 求原数组索引区间[0, i-1]元素之和。原数组索引从0开始
    def query(self, i):
        res = 0
        while i > 0:
            # 加上当前区间的和
            res += self.C[i]
            # 得到上一区间的尾结点
            i -= self.lowbit(i)
        return res

class NumArray(object):
    def __init__(self, nums):
        self.nums = nums
        self.tree = FenwickTree(len(nums))
        for i in range(len(nums)):
            self.tree.update(i+1, nums[i])

    def update(self, i, val):
        self.tree.update(i+1, val-self.nums[i])
        self.nums[i] = val

    def sumRange(self, i, j):
        return self.tree.query(j+1) - self.tree.query(i)



# 线段树
class NumArray2(object):
    def __init__(self, nums):
        # 取3倍长度
        self.value = [0]*len(nums)*3
        self.len = len(nums)-1
        if self.len >= 0:
            self.buildTree(nums, 0, 0, self.len)

    def update(self, i, val):
        self.updateTree(0, 0, self.len, i, val)

    def sumRange(self, i, j):
        return self.sumRangeTree(0, 0, self.len, i, j)

    # 构造线段树
    def buildTree(self, nums, pos, l, r):
        # 叶子节点
        if l == r:
            self.value[pos] = nums[l]
            return
        mid = (l+r)//2
        self.buildTree(nums, pos*2+1, l, mid)
        self.buildTree(nums, pos*2+2, mid+1, r)
        # 当前结点值等于左结点的值加右节点的值
        self.value[pos] = self.value[pos*2+1] + self.value[pos*2+2]

    # 对指定区间求和
    def sumRangeTree(self, pos, l, r, ql, qr):
        if ql > r or qr < l:
            return 0
        if ql <= l and qr >= r:
            return self.value[pos]
        mid = (l+r)//2
        return self.sumRangeTree(pos*2+1, l, mid, ql, qr) + self.sumRangeTree(pos*2+2, mid+1, r, ql, qr)

    # 更新线段树
    def updateTree(self, pos, l, r, index, newval):
        if l == r and l == index:
            self.value[pos] = newval
            return
        mid = (l+r)//2
        if index <= mid:
            self.updateTree(pos*2+1, l, mid, index, newval)
        else:
            self.updateTree(pos*2+2, mid+1, r, index, newval)
        self.value[pos] = self.value[pos*2+1] + self.value[pos*2+2]