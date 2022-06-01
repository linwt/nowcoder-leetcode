// 41. 数据流中的中位数


/*
优先级队列：
1、min表示排序数组的左半部分，从左到右降序排序
   max表示排序数组的右半部分，从左到右升序排序
2、添加元素的过程
  1）将元素加入min中
  2）将min中的最大值，即队头元素弹出加入max
  3）如果min的长度小于max，则平衡长度，将max中的最小值，即队头元素弹出加入min
3、计算中位数，min的队头和max的队头表示整个排序数组的中间位置，直接获取计算
 */
public class Solution {
    private PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    private PriorityQueue<Integer> max = new PriorityQueue<>();

    public void Insert(Integer num) {
        min.offer(num);
        max.offer(min.poll());
        if (min.size() < max.size()) {
            min.offer(max.poll());
        }
    }

    public Double GetMedian() {
        if (min.size() > max.size()) {
            return (double) min.peek();
        } else {
            return (double) (min.peek() + max.peek()) / 2;
        }
    }
}


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
