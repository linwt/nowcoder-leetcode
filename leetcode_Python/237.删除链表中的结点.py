# 方法一
class Solution(object):
    def deleteNode(self, node):
        # 把下一位的值赋给待删值
        node.val = node.next.val
        # 结点得到新值，next指针指向下下位，即删除了一个同值结点
        node.next = node.next.next

# 方法二：依次往前赋值，将倒数第二个结点的next指向空，即删除了最后一个同值结点
class Solution(object):
    def deleteNode(self, node):
        while node.next:
            node.val = node.next.val
            pre, node = node, node.next
        pre.next = None