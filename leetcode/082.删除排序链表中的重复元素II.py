# 方法一：数组去重再连接成链表
class Solution(object):
    def deleteDuplicates(self, head):
        if not head:
            return
        # 将链表结点值存放在数组
        res = []
        while head:
            res.append(head.val)
            head = head.next
        # 去除重复的元素
        res2 = []
        for i in res:
            if res.count(i) == 1:
                res2.append(i)
        # 将数组元素连接成链表
        h = head = ListNode(0)
        for i in res2:
            head.next = ListNode(i)
            head = head.next
        return h.next

# 方法二：pre跟踪head的前一个结点进行判断，cur跟踪新链表的尾结点
class Solution(object):
    def deleteDuplicates(self, head):
        # 创建起始结点，不影响原链表
        res = pre = cur = ListNode(None)
        # 遍历链表结点
        while head:
            # 结点值与左或右相同时，说明重复，指针向前移动。求结点的值时要先判断结点是否存在
            while head and ((head.val==pre.val) or (head.next and head.val==head.next.val)):
                pre = head
                head = head.next
            # 不重复时连接到新链表
            cur.next = head
            cur = cur.next
            # 尾结点可能为重复结点，需要先判断head是否为空，再继续遍历下一个结点
            if head:
                head = head.next
        return res.next

# 方法三：递归
class Solution(object):
    # 方法的作用是：参数给一个跟前面结点不重复的head，再判断跟后面结点是否重复，
    # 不重复则返回head，重复则返回head.next，head.next可能有不重复结点也可能为空
    def deleteDuplicates(self, head):
        if not head:
            return None
        lat, dup = head.next, False
        while lat and lat.val == head.val:
            lat, dup = lat.next, True
        head.next = self.deleteDuplicates(lat)
        return head.next if dup else head