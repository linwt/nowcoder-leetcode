# 方法一：使用正则表达式
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        for char in ransomNote:
            # 将magazine的char字符替换为空，且只能替换一次
            new_mag, num = re.subn(char, '', magazine, count=1)
            magazine = new_mag
            # 替换次数为0
            if not num:
                return False
        return True

# 方法二：先统计字符的个数，再比较个数大小
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        ranCounter = collections.Counter(ransomNote)
        magCounter = collections.Counter(magazine)
        for k in ranCounter:
            if ranCounter.get(k) > magCounter.get(k):
                return False
        return True

# 方法三：使用字典累加字符与个数，再逐一消减判断
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        d = {}
        for i in magazine:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1

        for i in ransomNote:
            if i not in d:
                return False
            d[i] -= 1
            if d[i] < 0:
                return False

        return True