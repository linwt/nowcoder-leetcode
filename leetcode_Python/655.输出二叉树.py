class Solution(object):
    def printTree(self, root):

        # 求树的深度
        def high(root):
            if not root:
                return 0
            return 1 + max(high(root.left), high(root.right))

        # 得到数组的大小
        height, width = high(root), 2**high(root)-1
        res = [['' for j in range(width)] for i in range(height)]

        # 判断每个结点的位置
        def locat(res, root, h, w):
            if root:
                res[h-1][w] = str(root.val)
                locat(res, root.left, h+1, w-2**(height-h-1))
                locat(res, root.right, h+1, w+2**(height-h-1))

        locat(res, root, 1, width/2)
        return res