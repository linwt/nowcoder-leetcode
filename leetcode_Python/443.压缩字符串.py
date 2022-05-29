class Solution(object):
    def compress(self, chars):
        n = len(chars)
        cur = 0
        i = 0
        while i < n:
            # 将j索引指向最后一个重复的字符
            j = i
            while j < n-1 and chars[j] == chars[j+1]:
                j += 1
            # 保存当前字符，cur移到下一位索引
            chars[cur] = chars[i]
            cur += 1
            # 有重复字符
            if i != j:
                times = str(j-i+1)
                tLen = len(times)
                for k in range(tLen):
                    chars[cur+k] = times[k]
                cur += tLen
            # 继续判断下个字符
            i = j+1
        # 返回索引代表数组长度
        return cur