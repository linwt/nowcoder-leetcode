# 用集合存放所有可能的字符长度的全排列
from itertools import permutations
class Solution(object):
    def numTilePossibilities(self, tiles):
        res = set()
        for item_len in range(1, len(tiles)+1):
            for item in permutations(tiles, item_len):
                res.add(item)
        return len(res)


# 回溯法，组合所有可能的字符串
class Solution(object):
    def numTilePossibilities(self, tiles):
        res = set()

        def genrate(output, tiles):
            if output:
                res.add(output)
            for i in range(len(tiles)):
                genrate(output + tiles[i], tiles[:i] + tiles[i+1:])

        genrate('', tiles)
        return len(res)


# 回溯法，记录字母个数
class Solution(object):
    def numTilePossibilities(self, tiles):
        def dfs(counter):
            res = 0
            for i in range(26):
                if not counter[i]:
                    continue
                res += 1
                counter[i] -= 1
                res += dfs(counter)
                counter[i] += 1
            return res

        counter = [0]*26
        for i in tiles:
            counter[ord(i) - ord('A')] += 1
        return dfs(counter)
