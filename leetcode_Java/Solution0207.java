// 207. 课程表


/*
拓扑排序，广度优先搜索
1、入度数组 inDegree 记录每门课程的入度
2、邻接表 adjacent，key为课程号，value为依赖该课程的其他课程号数组
3、遍历先修课程数组 prerequisites，更新入度数组 inDegree 和邻接表 adjacent
4、队列 queue 存放入度为0的课程号，即没有先修课程，可以选修
5、从队列弹出课程号，表示该课程已修。然后获取已修课程的后继课程列表 successorList，更新所有后继课程的入度减1。
  当后继课程入度为0时，则该课程可选修，将课程号存入队列。循环从队列弹出处理，直到没有可选修的课程
6、遍历入度数组 inDegree，判断所有课程号入度是否为0，不为0则不能修完所有课程，为0则能修完

示例：n = 6，先决条件表：[[3, 0], [3, 1], [4, 1], [4, 2], [5, 3], [5, 4]]
    课程 0, 1, 2 没有先修课，可以直接选。其余的课，都有两门先修课。
    用有向图来展现这种依赖关系（做事情的先后关系），这种叫 有向无环图，把一个 有向无环图 转成 线性的排序 就叫 拓扑排序。
    拓扑排序是将 有向无环图 所有顶点排成一个线性序列，使得图中任意一对顶点 u 和 v，若边 <u,v> ∈ E(G)，则 u 在线性序列中出现在 v 之前
    有向图有 入度 和 出度 的概念：如果存在一条有向边 A --> B，则这条边给 A 增加了 1 个出度，给 B 增加了 1 个入度。
    所以，顶点 0、1、2 的入度为 0，顶点 3、4、5 的入度为 2
拓扑排序过程：
    1）先统计所有节点的入度
    2）将入度为0的端点输出，删除该端点和该端点出发的有向边，并将后继端点入度减1
    3）重复步骤2，如果最后有入度不为0的端点说明存在环，不存在拓扑排序，否则存在拓扑排序

     0
        ↘
           3
        ↗     ↘
     1           5     拓扑排序：0 1 2 3 4 5
        ↘      ↗
           4
        ↗
     2
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int[] relate : prerequisites) {
            int cur = relate[1];
            int next = relate[0];
            inDegree.put(next, inDegree.get(next) + 1);
            if (!adjacent.containsKey(cur)) {
                adjacent.put(cur, new ArrayList<>());
            }
            adjacent.get(cur).add(next);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!adjacent.containsKey(cur)) {
                continue;
            }
            List<Integer> successorList = adjacent.get(cur);
            for (int next : successorList) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}