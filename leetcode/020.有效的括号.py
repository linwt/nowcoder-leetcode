# 利用栈找对应括号，遇到左括号则进栈，遇到右括号则出栈，判断两个括号是否匹配
class Solution(object):
    def isValid(self, s):
        left, right = '([{', '}])'
        stack = []
        for i in s:
            if i in left:
                stack.append(i)
            if i in right:
                if not stack:
                    return False
                res = stack.pop()
                if (i==')' and res!='(') or (i==']' and res!='[') or (i=='}' and res!='{'):
                    return False
        return not stack