class Trie(object):

    def __init__(self):
        self.root = {}

    def insert(self, word):
        # 直接赋值引用，同步更新
        node = self.root
        # 遍历单词每个字符，逐层向内扩展当前字典树
        for char in word:
            node = node.setdefault(char, {})
        # 结尾添加结束标志
        node['end'] = ''

    def search(self, word):
        node = self.root
        # 遍历单词每个字符，逐层向内更新当前字典树
        for char in word:
            if char not in node:
                return False
            node = node[char]
        # 遍历完成，判断最后一个键是否为结束标志
        return 'end' in node

    def startsWith(self, prefix):
        node = self.root
        # 遍历前缀每个字符，逐层向内更新当前字典树
        for char in prefix:
            # 字符不在字典树中，表示前缀不存在
            if char not in node:
                return False
            node = node[char]
        # 前缀遍历完成，表示存在该前缀
        return True