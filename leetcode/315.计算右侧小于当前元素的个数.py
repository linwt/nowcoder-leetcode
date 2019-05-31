# 从右往左获取元素，则按序插入的索引即为右边比它小的元素个数
# bisect_left获取待插入位置的索引，res存放该索引，seen存放排序的元素
class Solution(object):
    def countSmaller(self, nums):
        res, seen = [], []
        for num in nums[::-1]:
            index = bisect.bisect_left(seen, num)
            res.append(index)
            seen.insert(index, num)
        return res[::-1]



# 暴力，超时
class Solution2(object):
    def countSmaller(self, nums):
        res = []
        for i in range(len(nums)):
            count = 0
            for j in range(i, len(nums)):
                if nums[i] > nums[j]:
                    count += 1
            res.append(count)
        return res



# 二叉搜索树
class TreeNode(object):
    def __init__(self, val):
        self.left = None
        self.right = None
        self.val = val
        # 左子树结点个数
        self.count = 0

class Solution3(object):
    def countSmaller(self, nums):
        n = len(nums)
        root = None
        res = [0 for _ in range(n)]
        # 元素从右往左插入树，则可直接判断数组右侧小于当前元素的个数
        for i in reversed(range(n)):
            # 当前元素构造完成后得到根结点，再递归插入下一元素
            root = self.insertNode(root, nums[i], res, i)
        return res

    def insertNode(self, root, val, res, res_index):
        # 若结点为空，则根据传入值构造结点
        if not root:
            root = TreeNode(val)
        elif val <= root.val:
            root.count += 1
            root.left = self.insertNode(root.left, val, res, res_index)
        elif val > root.val:
            # 统计右侧小于当前元素的个数，即左子树结点个数和根结点
            res[res_index] += root.count + 1
            root.right = self.insertNode(root.right, val, res, res_index)
        # 当前元素插入树中后返回根结点
        return root



# 树状数组
class Solution4(object):
    def countSmaller(self, nums):
        def lowbit(x):
            # 等价于 x and (x xor (x-1))
            # -x 由 x 的二进制每一位取反再加1得到
            # 最终结果表示x二进制最低位1代表的值
            return x & -x

        # C[i]=A[i-2^k+1]+A[i-2^k+2]+...+A[i];  k表示i的二进制最低位连续0的个数
        # C[i]=A[i-lowbit(i)+1]+A[i-lowbit(i)+2]+...+A[i];
        # i+lowbit(i)可得到结点i的父节点，i-lowbit(i)可得到上一区间的尾结点
        def update(i, val, c):
            while i < len(c):
                # 当前结点值更新
                c[i] += val
                # 得到父节点
                i += lowbit(i)

        def getSum(i, c):
            ans = 0
            while i > 0:
                # 加上当前区间的和
                ans += c[i]
                # 得到上一区间的尾结点
                i -= lowbit(i)
            return ans

        new_nums = sorted(set(nums))
        d = {}
        for i in range(len(new_nums)):
            d[new_nums[i]] = i

        res = []
        l = len(new_nums)
        a = [0 for _ in range(l)]
        c = [0 for _ in range(l+1)]
        for i in range(len(nums)-1, -1, -1):
            num = d[nums[i]]
            a[num] += 1
            update(num+1, 1, c)
            res.append(getSum(num, c))

        return res[::-1]