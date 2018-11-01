class Solution:
    def match(self, s, pattern):
        if not s and not pattern:
            return True
        if s and not pattern:
            return False
        # 第二个字符为*     p=a*
        if len(pattern)>1 and pattern[1]=='*':
            # 第一个字符匹配  s=a   p=a*或p=.*
            if len(s)>0 and (s[0]==pattern[0] or pattern[0]=='.'):
                #                    *表示出现0次                        *表示出现1次                      *表示出现多次
                return self.match(s, pattern[2:]) or self.match(s[1:], pattern[2:]) or self.match(s[1:], pattern)
            # 第一个字符不匹配
            else:
                return self.match(s, pattern[2:])
        # 第二个字符不为*，且第一个字符匹配
        if len(s)>0 and (s[0]==pattern[0] or pattern[0]=='.'):
            return self.match(s[1:], pattern[1:])
        return False