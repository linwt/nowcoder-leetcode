# 将G的元素放入Set，遍历head，若遇到一个元素在Set中并且下一个元素为空或者不在Set中，则将组件个数加1
class Solution(object):
    def numComponents(self, head, G):
        count = 0
        g = set(G)
        while head:
            if head.val in g and (not head.next or head.next.val not in g):
                count += 1
            head = head.next
        return count