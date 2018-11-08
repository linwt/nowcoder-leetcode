num = raw_input()
count = int(raw_input())
stack = []
for i in num:
    while stack and count:
        # 后面的数比前面大时，则前面的数弹出，保证从左到右以由大到小的顺序排列
        if stack[-1] < i:
            stack.pop()
            count -= 1
        else:
            break
    stack.append(i)
if count:
    stack = stack[:-count]
print(''.join(stack))