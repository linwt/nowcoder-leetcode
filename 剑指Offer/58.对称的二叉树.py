# 判断左右子树对称的两个结点是否相同
# 嵌套方法写法
class Solution:
    def isSymmetrical(self, pRoot):
        def isSameTree(p, q):
            if not p and not q:
                return True
            if p and q and p.val==q.val:
                l = isSameTree(p.left, q.right)
                r = isSameTree(p.right, q.left)
                return l and r
            else:
                return False

        if not pRoot:
            return True
        return isSameTree(pRoot.left, pRoot.right)

# 单独调用写法
class Solution:
    def isSymmetrical(self, pRoot):
        if not pRoot:
            return True
        return self.isSameTree(pRoot.left, pRoot.right)

    def isSameTree(self, p, q):
        if not p and not q:
            return True
        if p and q and p.val==q.val:
            l = self.isSameTree(p.left, q.right)
            r = self.isSameTree(p.right, q.left)
            return l and r
        return False

################################  递归思路  ########################################
    # 1、极简化方法作用
    # 2、先只处理 “无” 与 “1” 的情况
    # 3、再处理用 “2”或“3” 代表 “多” 的情况，含有相同需求或逻辑则使用递归处理

    # 方法作用极简化：判断两个结点是否相同
    def isSameTree(self, p, q):
        # 没有结点的情况
        if not p and not q:
            return True
        # 各1个结点且相等的情况
        if p and q and p.val==q.val:
            return True
        # 其他
        return False

    def isSameTree(self, p, q):
        # 没有结点的情况
        if not p and not q:
            return True
        # 结点含有左右子结点的情况。各1个结点且相等的情况可合并，故省略
        if p and q and p.val==q.val:
            # 需要再判断各自左右结点是否相同，使用递归
            l = self.isSameTree(p.left, q.right)
            r = self.isSameTree(p.right, q.left)
            return l and r
        # 其他
        return False