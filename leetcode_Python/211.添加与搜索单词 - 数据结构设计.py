# 将单词按照长度归类存到字典中，匹配时逐个遍历比较相同长度的单词
class WordDictionary(object):

    def __init__(self):
        from collections import defaultdict
        self.d = defaultdict(list)

    def addWord(self, word):
        self.d[len(word)] += [word]

    def search(self, word):
        n = len(word)
        for w in self.d[n]:
            for i in range(n):
                if word[i] == '.':
                    continue
                if word[i] != w[i]:
                    break
            else:
                return True
        return False


# 字典树，回溯法
class WordDictionary(object):

    def __init__(self):
        # {'b': {'a': {'d': {'#': {}}}}, 'd': {'a': {'d': {'#': {}}}}, 'm': {'a': {'d': {'#': {}}}}}
        self.lookup = {}

    def addWord(self, word):
        tree = self.lookup
        for a in word:
            tree = tree.setdefault(a, {})
        tree["#"] = {}

    def search(self, word):
        def helper(word, tree):
            # 递归终止条件
            if not word:
                # 搜索完最后一个字符
                if "#" in tree:
                    return True
                # 未搜索完
                return False
            # 如果字符是'.'，需要遍历判断每个字典树
            if word[0] == ".":
                for t in tree:
                    if helper(word[1:], tree[t]):
                        return True
            # 如果字符在字典中，只需要判断该字符的字典树
            elif word[0] in tree:
                if helper(word[1:], tree[word[0]]):
                    return True
            # 字符不在字典中
            return False
        return helper(word, self.lookup)