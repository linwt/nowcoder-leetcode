# 字典树
class MapSum(object):

    def __init__(self):
        self.root = {}

    def insert(self, key, val):
        # 直接赋值引用，同步更新
        node = self.root
        # 遍历单词每个字符，逐层向内扩展当前字典树
        for char in key:
            node = node.setdefault(char, {})
        # 结尾添加结束标志
        node['end'] = val

    def sum(self, prefix):
        node = self.root
        # 遍历前缀每个字符，逐层向内更新，得到该前缀下的字典树
        for char in prefix:
            node = node.setdefault(char, {})

        self.res = 0

        # 递归遍历得到当前字典树所有值
        def dfs(node):
            for key, val in node.items():
                if key == 'end':
                    self.res += val
                else:
                    dfs(val)

        dfs(node)
        return self.res


# 普通字典
class MapSum2(object):

    def __init__(self):
        self.d = {}

    def insert(self, key, val):
        self.d[key] = val

    def sum(self, prefix):
        res = 0
        for key in self.d:
            if prefix == key[:len(prefix)]:
                res += self.d[key]
        return res

    # def sum(self, prefix):
    #     res = 0
    #     for key, val in self.d.items():
    #         if key.startswith(prefix):
    #             res += val
    #     return res