# 字符串分割、提取、合并
class Solution(object):
    def numUniqueEmails(self, emails):
        res = set()
        for email in emails:
            local, domain = email.split('@')[0], email.split('@')[1]
            local = local.split('+')[0]
            local = ''.join([i for i in local if i != '.'])
            res.add(local + '@' + domain)
        return len(res)

# 一行代码
class Solution(object):
    def numUniqueEmails(self, emails):
        return len(set([email.split('@')[0].split('+')[0].replace('.', '') + '@' + email.split('@')[1] for email in emails]))