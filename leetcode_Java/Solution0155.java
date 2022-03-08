// 155. 最小栈


/*
使用辅助栈，与元素栈同步插入与删除，用于存储与每个元素当前对应的最小值
 */
class MinStack {

    Stack stack, minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min((int) minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return (int) minStack.peek();
    }
}


/*
变量保存当前最小值，栈同时保存历史最小值，防止历史最小值丢失
 */
class MinStack {

    Stack stack;
    int minVal;

    public MinStack() {
        stack = new Stack();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= minVal) {
            stack.push(minVal);
            minVal = val;
        }
        stack.push(val);
    }

    public void pop() {
        if ((int) stack.pop() == minVal) {
            minVal = (int) stack.pop();
        }
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return minVal;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */