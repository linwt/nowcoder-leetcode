class Codec:

    def serialize(self, root):
        def preorder(root):
            if root:
                res.append(str(root.val))
                preorder(root.left)
                preorder(root.right)
            else:
                res.append('#')

        res = []
        preorder(root)
        return ','.join(res)

    def deserialize(self, data):
        def createtree():
            val = next(vals)
            if val == '#':
                return
            root = TreeNode(int(val))
            root.left = createtree()
            root.right = createtree()
            return root

        vals = iter(data.split(','))
        return createtree()