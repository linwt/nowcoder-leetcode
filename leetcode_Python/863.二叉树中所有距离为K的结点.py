class Solution(object):
    def distanceK(self, root, target, K):
        # 字典的值类型是列表
        con = collections.defaultdict(list)

        def connect(parent, child):
            if parent and child:
                con[parent.val].append(child.val)
                con[child.val].append(parent.val)
            if child.left:
                connect(child, child.left)
            if child.right:
                connect(child, child.right)

        connect(None, root)
        res = [target.val]
        visited = set(res)
        for _ in range(K):
            res = [y for x in res for y in con[x] if y not in visited]
            # 合并
            visited |= set(res)
        return res