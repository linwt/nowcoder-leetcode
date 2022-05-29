class Solution:
    
    def __init__(self):
        self.flag = -1

    def Serialize(self, root):
        if not root:
            return '#,'
        return str(root.val) + ',' + self.Serialize(root.left) + self.Serialize(root.right)

    # if 写法一
    def Deserialize(self, s):
        self.flag += 1
        l = s.split(',')
        if l[self.flag] == '#':
            return None
        root = TreeNode(int(l[self.flag]))
        root.left = self.Deserialize(s)
        root.right = self.Deserialize(s)
        return root

    # if 写法二
    def Deserialize(self, s):
        self.flag += 1
        l = s.split(',')
        root = None
        if l[self.flag] != '#':
            root = TreeNode(int(l[self.flag]))
            root.left = self.Deserialize(s)
            root.right = self.Deserialize(s)
        return root

###################################  解释递归  ##############################################

# 序列化：将二叉树转为字符序列
# 反序列化：将字符序列转为二叉树
class Solution:
    def __init__(self):
        # 通过全局变量flag来迭代序列的值
        self.flag = -1



    # 方法作用极简化：将一个结点转为 “ 结点值，” 的形式
    def Serialize(self, root):
        # 没有结点的情况
        if not root:
            return '#,'
        # 1个结点的情况
        return str(root.val) + ','

    def Serialize(self, root):
        if not root:
            return '#,'
        # 1个结点的情况可合并到多个结点的情况，故省略
        # 2个或3个结点代表多个结点的情况。左右结点也需要转为 “ 结点值，” 的形式则递归调用，最后将各自转化结果拼接成字符串返回
        return str(root.val) + ',' + self.Serialize(root.left) + self.Serialize(root.right)



    # 方法作用极简化：将序列的一个值转化为一个结点
    def Deserialize(self, s):
        l = s.split(',')
        # 表示树为空的情况
        if l[0] == '#':
            return None
        # 1个结点的情况
        root = TreeNode(int(l[0]))
        return root

    def Deserialize(self, s):
        # 每次遍历序列都要迭代下一个值，引入全局变量flag
        self.flag += 1
        l = s.split(',')
        if l[self.flag] == '#':
            return None
        root = TreeNode(int(l[self.flag]))
        # 2个或3个结点代表多个结点的情况。左右结点也需要将序列的一个值转化为一个结点则递归调用
        root.left = self.Deserialize(s)
        root.right = self.Deserialize(s)
        return root
