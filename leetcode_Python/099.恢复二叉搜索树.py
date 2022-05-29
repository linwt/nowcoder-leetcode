# 1) 被交换的两个结点相邻，如124356，只需要把相邻的3和4交换回来即可；
# 2) 被交换的两个结点不相邻，如163452，需要找出两个逆序的地方，63和52，并交换第一个逆序的前者和第二个逆序的后者。
class Solution(object):
    def __init__(self):
        self.mistake1 = None
        self.mistake2 = None
        self.pre = None

    def recoverTree(self, root):
        if not root:
            return None
        self.findMistake(root)
        self.mistake1.val, self.mistake2.val = self.mistake2.val, self.mistake1.val

    def findMistake(self, root):
        if root.left:
            self.findMistake(root.left)
        if self.pre and root.val < self.pre.val:
            if not self.mistake1:
                self.mistake1 = self.pre
            self.mistake2 = root
        self.pre = root
        if root.right:
            self.findMistake(root.right)