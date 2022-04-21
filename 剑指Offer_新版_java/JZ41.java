// 41. 数据流中的中位数


public class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
        int len = list.size();
        if (len % 2 == 0) {
            return (double) (list.get(len / 2 - 1) + list.get(len / 2)) / 2;
        } else {
            return (double) list.get(len / 2);
        }
    }
}
