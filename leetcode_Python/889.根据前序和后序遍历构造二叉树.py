# 前序遍历的第一个元素，后续遍历的最后一个元素，是根节点
# 从前序看 2 是左树的根节点，我们需要知道左树的长度，从后序找到2的位置，则4，5，2 是整个左树
class Solution(object):
    def constructFromPrePost(self, pre, post):
        root = TreeNode(pre[0])
        pre = pre[1:]
        post = post[:-1]
        len_left = 0
        for i in post:
            if i == pre[0]:
                len_left += 1
                break
            else:
                len_left += 1
        if len_left > 0:
            root.left = self.constructFromPrePost(pre[:len_left], post[:len_left])
        if len(pre) - len_left > 0:
            root.right = self.constructFromPrePost(pre[len_left:], post[len_left:])
        return root