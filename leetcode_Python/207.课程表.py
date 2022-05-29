# 拓扑排序。构建邻接表，每一个结点存放后继结点的集合。若不存在循环，则存在拓扑排序，即最终顶点个数与课程数相同
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        if not numCourses:
            return True
        # 初始化入度和邻接表
        in_degrees = [0 for _ in range(numCourses)]
        adj = [set() for _ in range(numCourses)]
        # 更新入度和邻接表
        for second, first in prerequisites:
            in_degrees[second] += 1
            adj[first].add(second)
        # 将入度为0的结点添加到队列
        queue = []
        for i in range(numCourses):
            if in_degrees[i] == 0:
                queue.append(i)

        count = 0
        while queue:
            # 弹出入度为0的结点并统计个数
            top = queue.pop(0)
            count += 1
            # 将该结点的所有邻接点入度减1，若邻接点入度为0则将其添加到队列中
            for successor in adj[top]:
                in_degrees[successor] -= 1
                if in_degrees[successor] == 0:
                    queue.append(successor)

        return count == numCourses


# 构建逆邻接表，实现深度优先遍历，当访问一个结点的时，递归访问它的前驱结点，直至前驱结点没有前驱结点为止。
# 检测这个有向图中有没有环，只要存在环，课程就不能完成。
class Solution2(object):
    def canFinish(self, numCourses, prerequisites):
        if not numCourses:
            return True
        # 初始化已访问表和逆邻接表
        visited = [0 for _ in range(numCourses)]
        inverse_adj = [set() for _ in range(numCourses)]
        # 更新逆邻接表
        for second, first in prerequisites:
            inverse_adj[second].add(first)
        # 遍历每个结点作为出发点，递归访问它的前驱结点，若遇到有环则退出
        for i in range(numCourses):
            if self.dfs(i, inverse_adj, visited):
                return False
        return True

    # 方法作用：传入结点，判断、更新结点状态，返回是否有环
    def dfs(self, vertex, inverse_adj, visited):
        # 访问新结点时判断该结点当前状态
        # 2表示正在被访问，说明有环
        if visited[vertex] == 2:
            return True
        # 1表示已访问过，该结点安全
        if visited[vertex] == 1:
            return False
        # 0表示未访问过，先置为2正在访问
        visited[vertex] = 2
        # 递归访问该结点的前驱结点
        for precursor in inverse_adj[vertex]:
            if self.dfs(precursor, inverse_adj, visited):
                return True
        # 递归完成，无环，回溯，置为1已访问
        visited[vertex] = 1
        return False