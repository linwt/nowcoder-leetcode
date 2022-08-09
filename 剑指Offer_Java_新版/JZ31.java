// 31. 栈的压入、弹出序列


// 数据入栈，当数据与弹出序列头元素相等时，则数据出栈且序列头元素弹出，重复以上步骤，最终若栈为空则该序列是符合的弹出序列
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : pushA) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
