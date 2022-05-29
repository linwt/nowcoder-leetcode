# 方法一：使用两个数组模拟栈
class Solution:
    def __init__(self):
        self.stack = []
        self.min_stack = []
    def push(self, node):
        self.stack.append(node)
        if not self.min_stack or node <= self.min_stack[-1]:
            self.min_stack.append(node)
    def pop(self):
        if self.stack[-1] == self.min_stack[-1]:
            self.min_stack.pop()
        self.stack.pop()
    def top(self):
        return self.stack[-1]
    def min(self):
        return self.min_stack[-1]

# 方法二：使用一个数组模拟栈
class Solution:
    def __init__(self):
        self.stack = []
    def push(self, node):
        self.stack.append(node)
    def pop(self):
        self.stack.pop()
    def top(self):
        return self.stack[-1]
    def min(self):
        return min(self.stack)