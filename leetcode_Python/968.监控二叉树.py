#0：该结点附近有未被监视结点，安装监控器
#1：该结点周围有监控器或该结点不存在，都不用安装监控器
#2：该结点附近没有监控器，表示其附近需要监控器
class Solution(object):
    def minCameraCover(self, root):
        self.res = 0
        if self.dfs(root) == 2:
            self.res += 1
        return self.res

    def dfs(self, root):
        if not root:
            return 1
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        if left == 2 or right == 2:
            self.res += 1
            return 0
        elif left == 0 or right == 0:
            return 1
        else:
            return 2

# 贪心算法，自底向上，在有孩子的结点上安装摄像头最多可监控4个结点，即自己、左右孩子、父节点
class Solution2(object):
    def minCameraCover(self, root):
        if not root.left and not root.right:
            return 1
        # 层次遍历将所有节点保存下来
        parents, nodes, cur = {root:None}, [], collections.deque([root])
        while cur:
            node = cur.popleft()
            if node.left:
                parents[node.left] = node
                cur.append(node.left)
            if node.right:
                parents[node.right] = node
                cur.append(node.right)
            nodes.append(node)

        vis = {}
        for node in nodes[::-1]:
            parent = parents[node]
            # 若当前结点被监控，即当前结点或左右孩子安装了摄像头，则跳过遍历下一结点
            if node in vis or node.left in vis or node.right in vis:
                continue
            # 否则在父节点安装摄像头
            vis[parent] = 1
        return sum(vis.values())