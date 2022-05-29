# 方法一
class Codec:
    def __init__(self):
        self.flag = -1

    def serialize(self, root):
        if not root:
            return '#,'
        return str(root.val) + ',' + self.serialize(root.left) + self.serialize(root.right)

    def deserialize(self, data):
        self.flag += 1
        l = data.split(',')
        if l[self.flag] == '#':
            return
        root = TreeNode(int(l[self.flag]))
        root.left = self.deserialize(data)
        root.right = self.deserialize(data)
        return root

# 方法二
class Codec:

    def serialize(self, root):
        def preorder(root):
            if root:
                result.append(str(root.val))
                preorder(root.left)
                preorder(root.right)
            else:
                result.append("#")
        result = []
        preorder(root)
        return ','.join(result)

    def deserialize(self, data):

        def change(num):
            num[0] += 1
            if num[0] < len(s):
                if s[num[0]] == "#":
                    return None
                root = TreeNode(int(s[num[0]]))
                root.left = change(num)
                root.right = change(num)
                return root
            else:
                return None

        s = data.split(',')
        num = [-1]
        return change(num)