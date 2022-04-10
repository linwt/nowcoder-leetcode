// 56. 合并区间


/*
遍历区间，加入新区间 或 更新结果数组最后一个区间的右端点值成为新合并区间
1、先将列表中的区间按照左端点升序排序
2、遍历二维数组
  1）第一个区间则直接加入结果数组
  2）如果 结果数组最后一个区间的右端点 小于 当前区间左端点，说明没有重合，当前区间加入结果数组
  3）如果 结果数组最后一个区间的右端点 大于等于 当前区间左端点，说明有重合，则更新结果数组最后一个区间右端点的值，该值为两右端点取较大者
3、列表转数组后返回

intervals = [[1,3],[2,6],[8,10],[15,18]]    res = [[1,3]]
               ↑
intervals = [[1,3],[2,6],[8,10],[15,18]]    res = [[1,6]]
                     ↑
intervals = [[1,3],[2,6],[8,10],[15,18]]    res = [[1,6],[8,10]]
                           ↑
intervals = [[1,3],[2,6],[8,10],[15,18]]    res = [[1,6],[8,10],[15,18]]
                                   ↑
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int size = res.size();
            if (size == 0 || res.get(size - 1)[1] < interval[0]) {
                res.add(new int[]{interval[0], interval[1]});
            } else {
                res.get(size - 1)[1] = Math.max(res.get(size - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}


/*
逻辑同上
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}


/*
先遍历多个区间，更新区间右端点值，找到一个合并区间后加入结果数组
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < n && right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
                i++;
            }
            i--;
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][]);
    }
}