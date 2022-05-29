class MagicDictionary(object):

    def __init__(self):
        self.d = []

    def buildDict(self, dict):
        self.d = dict

    # 列表元素比较，长度相同且仅一个字符不同则返回True
    def search(self, word):
        n = len(word)
        for key in self.d:
            if len(key) == n:
                count = 0
                for i in range(n):
                    if key[i] != word[i]:
                        count += 1
                if count == 1:
                    return True
        return False