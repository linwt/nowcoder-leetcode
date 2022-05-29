# 数据入栈，当数据与弹出序列头元素相等时，则数据出栈且序列头元素弹出，重复以上步骤，最终若栈为空则该序列是符合的弹出序列
def IsPopOrder(self, pushV, popV):
    if not pushV:
        return False
    stack = []
    for i in pushV:
        stack.append(i)
        while len(stack) and stack[-1] == popV[0]:
            stack.pop()
            popV.pop(0)
    if len(stack):
        return False
    return True