class Solution(object):
    def findFrequentTreeSum(self, root):
        if not root:
            return []
        if not root.left and not root.right:
            return [root.val]
        # 字典用于存放子树和与对应次数
        d = dict()

        def treesum(root):
            if not root:
                return 0
            tsum = root.val
            tsum += treesum(root.left)
            tsum += treesum(root.right)
            if not d.get(tsum):
                d[tsum] = 1
            else:
                d[tsum] += 1
            return tsum

        treesum(root)
        # 按照次数由大到小排序  [(2,2),(-5,1)]
        dsort = sorted(d.iteritems(), key=lambda x: x[1], reverse=True)
        return [dsort[i][0] for i in range(len(dsort)) if dsort[i][1] == dsort[0][1]]
