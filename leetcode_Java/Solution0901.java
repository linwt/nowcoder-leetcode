// 901. 股票价格跨度


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */


/*
单调递减栈：
1、栈存放索引，表示日期，方便计算最大连续日数
2、栈不为空 且 当前价格大于栈顶价格，则弹出栈顶价格
3、栈为空说明入栈的价格都弹出来了，跨度就是列表的长度
4、栈不为空，则计算栈顶日期与今天的日期差，得到跨度
 */
class StockSpanner {
    Deque<Integer> stack;
    List<Integer> list;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        int res = 0;
        list.add(price);
        while (!stack.isEmpty() && price >= list.get(stack.peek())) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            res = list.size();
        } else {
            res = list.size() - 1 - stack.peek();
        }
        stack.push(list.size() - 1);
        return res;
    }
}

