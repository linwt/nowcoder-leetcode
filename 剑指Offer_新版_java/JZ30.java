// 30. 包含min函数的栈


public class Solution {
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        int temp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}
