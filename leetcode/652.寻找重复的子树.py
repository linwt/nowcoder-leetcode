# 用字典存放序列化的子树，遍历过程若字典出现重复的序列化字符串，则将该子树添加到数组
class Solution(object):
    def findDuplicateSubtrees(self, root):
        global res, d
        res = []
        # value默认为0
        d = collections.defaultdict(int)
        self.findtree(root)
        return res

    def findtree(self, root):
        if not root:
            return '#'
        sontree = str(root.val) + ',' + self.findtree(root.left) + ',' + self.findtree(root.right)
        if d[sontree] == 1:
            res.append(root)
        d[sontree] += 1
        return sontree