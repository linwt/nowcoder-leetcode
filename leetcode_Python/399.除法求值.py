# 首先要把除法运算转化成图表示,比如a->b = 2.0  b->c = 3.0, a,b,c看成节点,相除所得值为权值.
# 那么a/c = ? 就是相当于 a->c <==> a->b->c = 2.0*3.0 = 6,所以要把已知条件建图!

# 深度优先搜索
class Solution(object):
    def calcEquation(self, equations, values, queries):
        # 存放结点及其邻接点
        graph = collections.defaultdict(set)
        # 存放每条边的权重
        weight = {}
        # 构建图
        for index, equa in enumerate(equations):
            graph[equa[0]].add(equa[1])
            graph[equa[1]].add(equa[0])
            weight[tuple(equa)] = values[index]
            weight[(equa[1], equa[0])] = float(1 / values[index])

        def dfs(start, end, visited):
            # 图中有这条边，直接返回
            if (start, end) in weight:
                return weight[(start, end)]
            # 图中没有该结点
            if start not in graph or end not in graph:
                return 0
            # 已经访问过
            if start in visited:
                return 0
            # 当前结点正在访问
            visited.add(start)
            w = 0
            # 深度优先遍历每个邻接点
            for temp in graph[start]:
                w = (weight[(start, temp)] * dfs(temp, end, visited))
                # 遍历到一个可行解则退出
                if w != 0:
                    # 添加此边，以后访问节省时间
                    weight[(start, end)] = w
                    break
            # 访问完成
            visited.remove(start)
            return w

        res = []
        for q in queries:
            w = dfs(q[0], q[1], set())
            if w == 0:
                w = -1.0
            res.append(w)
        return res


# 广度优先搜索
class Solution2(object):
    def calcEquation(self, equations, values, queries):
        graph = collections.defaultdict(set)
        weight = {}
        for index, equa in enumerate(equations):
            graph[equa[0]].add(equa[1])
            graph[equa[1]].add(equa[0])
            weight[tuple(equa)] = values[index]
            weight[(equa[1], equa[0])] = float(1 / values[index])

        res = []
        for start, end in queries:
            if (start, end) in weight:
                res.append(weight[(start, end)])
                continue
            if start not in graph or end not in graph:
                res.append(-1)
                continue
            if start == end:
                res.append(1.0)
                continue
            stack = collections.deque()
            for temp in graph[start]:
                stack.appendleft((temp, weight[(start, temp)]))
            visited = {start}
            flag = False
            while stack:
                c, w = stack.pop()
                if c == end:
                    flag = True
                    res.append(w)
                    break
                visited.add(c)
                for n in graph[c]:
                    if n not in visited:
                        weight[(start, n)] = w * weight[(c, n)]
                        stack.appendleft((n, w * weight[(c, n)]))
            if flag:
                continue
            res.append(-1.0)
        return res