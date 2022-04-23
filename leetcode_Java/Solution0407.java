// 407. 接雨水 II


/*
优先级队列：外圈到内圈访问，逐渐缩小圈
1、使用优先级队列存放外圈柱子三元组，即横坐标、纵坐标、高度，升序排序。因为木桶原理，内圈柱子能灌多少水取决于外圈最低柱子的高度
   访问数组标记柱子是否访问过，访问过则跳过
2、初始化，将外圈柱子三元组存入队列，并标记已访问
3、当队列不为空时，队列弹出元素为外圈最低柱子，遍历访问最低柱子的上下左右四个方向的柱子。四个方向的作用在于外圈有四个边界，各取所需访问到内圈柱子。
  方向数组把上下左右四个坐标压缩成一维数组，灵活获取坐标
4、因为外圈都被访问了，如果坐标有效，则说明柱子在圈内，所以如果被访问的柱子 坐标有效并且未访问，
  那么再判断外圈最低柱子与圈内柱子的高度差，如果高度差大于0，说明圈内柱子可以灌水体积为高度差，否则不能灌水
5、被访问过的内圈柱子将作为新的外圈柱子，加入到队列中，高度是外圈柱子与内圈柱子取较高者，并标记已访问
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    queue.offer(new int[] {i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dirs = {0, -1, 0, 1, 0};
        while (!queue.isEmpty()) {
            int[] minSide = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = minSide[0] + dirs[k];
                int y = minSide[1] + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    int heighDiff = minSide[2] - heightMap[x][y];
                    if (heighDiff > 0) {
                        res += heighDiff;
                    }
                    queue.offer(new int[] {x, y, Math.max(minSide[2], heightMap[x][y])});
                    visited[x][y] = true;
                }
            }
        }
        return res;
    }
}