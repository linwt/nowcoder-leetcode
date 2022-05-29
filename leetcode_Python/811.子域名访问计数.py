class Solution(object):
    def subdomainVisits(self, cpdomains):
        d = {}
        for i in cpdomains:
            # 先切分并保存最低一级域名与次数
            res = i.split()
            num = int(res[0])
            addr = res[1]
            if addr in d:
                d[addr] += num
            else:
                d[addr] = num
            # 再保存父域名和顶级域名的访问次数
            while '.' in addr:
                addr = addr[addr.index('.')+1:]
                if addr in d:
                    d[addr] += num
                else:
                    d[addr] = num
        return [str(d[key]) + ' ' + key for key in d]