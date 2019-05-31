# 暴力法。每个单词对应遍历整个词典，判断是否包含词根，有则替换
class Solution(object):
    def replaceWords(self, dict, sentence):
        words = sentence.split(' ')
        for i in range(len(words)):
            for pre in dict:
                # if words[i].startswith(pre):
                if pre == words[i][:len(pre)]:
                    words[i] = pre
        return ' '.join(words)


# 字典树
class Solution2(object):
    def __init__(self):
        self.e = 'end'
        self.dtree = {}

    def replaceWords(self, dict, sentence):
        self.build_tree(dict)
        res = [self.replace(word) for word in sentence.split(' ')]
        return ' '.join(res)

    def replace(self, word):
        cur = self.dtree
        # 遍历单词的每个字符
        for index, char in enumerate(word):
            # 若该字符出现在字典树中
            if char in cur:
                # 更新当前字典树
                cur = cur[char]
                # 判断前缀是否结束
                if self.e in cur:
                    return word[:index+1]
            # 若无，则直接返回该单词
            else:
                return word
        # 单词遍历完，前缀未结束，直接返回该单词
        return word

    # {'b': {'a': {'t': {'end': ''}}}, 'r': {'a': {'t': {'end': ''}}}, 'c': {'a': {'t': {'end': ''}}}}
    def build_tree(self, dict):
        # 遍历每个词根
        for pre in dict:
            # 直接赋值引用，同步更新
            cur = self.dtree
            # 遍历词根的每个字符
            for char in pre:
                # 如果该字符不在当前字典中，则当前字符键的值设为空字典
                if char not in cur:
                    cur[char] = {}
                # 当前字典更新为此字符键的值字典
                cur = cur[char]
            # 字符遍历完成在尾部添加结束标志
            cur[self.e] = ''