class Solution(object):
    def cloneGraph(self, node):
        return copy.deepcopy(node)


# 广度优先搜索
class Solution2(object):
    def cloneGraph(self, node):
        d = {}
        # 拷贝第一个新结点到字典
        d[node] = Node(node.val, [])
        # 第一个旧结点添加到队列
        queue = [node]
        while queue:
            cur_node = queue.pop(0)
            # 遍历当前结点的邻居结点
            for nodes in cur_node.neighbors:
                if nodes not in d:
                    # 拷贝新邻居结点到字典
                    d[nodes] = Node(nodes.val, [])
                    # 添加旧邻居结点到队列
                    queue.append(nodes)
                # 拷贝新结点的邻居结点
                d[cur_node].neighbors.append(d[nodes])
        # 返回第一个新结点
        return d[node]


# 深度优先搜索
class Solution3(object):
    def cloneGraph(self, node):
        # 方法作用：传入结点，拷贝结点值，拷贝邻居，返回结点
        def dfs(node):
            # 终止条件
            if not node:
                return
            # 拷贝新结点并添加到字典中
            new_node = Node(node.val, [])
            d[node] = new_node
            # 遍历旧结点的邻居结点
            for i in node.neighbors:
                # 若邻居结点不在字典中，则递归拷贝邻居结点
                if i not in d:
                    new_node.neighbors.append(dfs(i))
                # 否则直接添加邻居结点
                else:
                    new_node.neighbors.append(d[i])
            # 返回新结点
            return new_node

        d = {}
        return dfs(node)