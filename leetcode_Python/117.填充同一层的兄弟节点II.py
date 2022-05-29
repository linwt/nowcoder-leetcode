class Solution:
    def connect(self, root):
        global res
        res = []
        self.addLayer(root, 0)
        for level in res:
            for i in range(len(level)-1):
                level[i].next = level[i+1]

    def addLayer(self, root, level):
        if not root:
            return
        # 有下一层时添加一个数组存放下一层结点
        if len(res) < level+1:
            res.append([])
        # 将结点添加到对应层的数组中
        res[level].append(root)
        self.addLayer(root.left, level+1)
        self.addLayer(root.right, level+1)