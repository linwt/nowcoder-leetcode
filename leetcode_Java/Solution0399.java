// 399. 除法求值


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        Map<String, Integer> map = new HashMap<>(2 * size);
        UnionFind unionFind = new UnionFind(2 * size);
        int id = 0;
        double[] res = new double[queries.size()];
        for (List<String> list : equations) {
            String val1 = list.get(0);
            String val2 = list.get(1);
            if (!map.containsKey(val1)) {
                map.put(val1, id);
                id++;
            }
            if (!map.containsKey(val2)) {
                map.put(val2, id);
                id++;
            }
        }
        for (int i = 0; i < size; i++) {
            int val1 = map.get(equations.get(i).get(0));
            int val2 = map.get(equations.get(i).get(1));
            unionFind.union(val1, val2, values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            if (map.containsKey(queries.get(i).get(0)) && map.containsKey(queries.get(i).get(1))) {
                int val1 = map.get(queries.get(i).get(0));
                int val2 = map.get(queries.get(i).get(1));
                res[i] = unionFind.getValue(val1, val2);
            } else {
                res[i] = -1.0d;
            }
        }
        return res;
    }
}

class UnionFind {
    int[] parent;
    double[] weight;  // 表示当前节点到根节点的值

    public UnionFind(int size) {
        this.parent = new int[size];
        this.weight = new double[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }

    //找到当前节点的根节点，在查询的同时进行路径压缩
    public int find(int x) {
        if (x != parent[x]) {
            int temp = parent[x];
            parent[x] = find(parent[x]);
            weight[x] = weight[x] * weight[temp];
        }
        return parent[x];
    }

    //将两个节点进行合并
    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        } else {
            parent[rootX] = rootY;
            weight[rootX] = value * weight[y] / weight[x];
        }
    }

    //判断两个节点是否属于同一个分组
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    //返回连个节点的比值
    public double getValue(int x, int y) {
        if (!isConnected(x, y)) {
            return -1.0d;
        } else {
            return weight[x] / weight[y];
        }
    }
}