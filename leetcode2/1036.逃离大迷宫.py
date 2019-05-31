class Solution(object):
    def isEscapePossible(self, blocked, source, target):
        ds = ((1,0), (0,1), (-1,0), (0,-1))
        # 元组节省空间
        blocks = set(map(tuple, blocked))
        T = 999999

        def not_circle(p):
            cur = [p]
            vis = set()
            vis.add(tuple(p))
            for _ in range(50):
                next = list()
                # 遍历当前可到达的方格
                for i, j in cur:
                    # 遍历每个方格四个方向的方格
                    for di, dj in ds:
                        ni, nj = i+di, j+dj
                        # 方格在有效范围内，未访问过，且不在封锁列表中
                        if 0<=ni<=T and 0<=nj<=T and (ni,nj) not in vis and (ni,nj) not in blocks:
                            # 将该方格添加到下一可访问列表和已访问列表
                            next.append((ni,nj))
                            vis.add((ni,nj))
                cur = next
            # 判断50次遍历搜寻后当前是否还有可访问的方格，若没有则说明封闭
            return bool(cur)

        # 判断起点和终点是否连通
        return not_circle(source) and not_circle(target)