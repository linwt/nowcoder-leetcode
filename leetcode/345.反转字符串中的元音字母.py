# 方法一：利用左右索引寻找元音字符交换
class Solution(object):
    def reverseVowels(self, s):
        list_s = list(s)
        vowels = 'aeiouAEIOU'
        l, r = 0, len(s)-1
        while l <= r:
            if list_s[l] not in vowels:
                l += 1
            elif list_s[r] not in vowels:
                r -= 1
            else:
                list_s[l], list_s[r] = list_s[r], list_s[l]
                l += 1
                r -= 1
        return ''.join(list_s)

# 方法二：正则表达式
class Solution(object):
    def reverseVowels(self, s):
        vowels = re.findall(r'[aeiouAEIOU]', s)
        return re.sub('[aeiouAEIOU]', lambda m: vowels.pop(), s)