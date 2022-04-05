// 232. 用栈实现队列


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


/*
1、stack1作为队列，元素正序。stack2作为辅助工具，不存放元素
2、push：先把stack1倒入stack2，元素压入stack1，再把stack2倒入stack1。实现了新元素在栈底，且整体正序
3、pop：直接弹出stack1栈顶
4、peek：直接查看stack1栈顶
5、empty：直接判断stack1是否为空
 */
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}


/*
1、stack1作为栈，元素倒序。stack2作为队列，元素正序
2、push：入栈就入stack1。push时如果stack1为空，记录队首元素，再入栈。队首元素用于peek时直接返回
3、pop：出栈就出stack2。stack2如果为空就把stack1倒入stack2，stack2不为空就弹出栈顶
4、peek：查看队首元素。stack2不为空那么栈顶就是队首，stack2为空那么就返回stack1记录的栈底队首元素
5、empty：stack1和stack2都为空时则空
 */
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int head;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            head = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return head;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

