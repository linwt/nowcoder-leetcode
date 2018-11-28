class Solution(object):
    def reorderList(self, head):
        if not head or not head.next or not head.next.next:
            return
        
        # 快慢指针，获取后半段链表，并将前半段尾指针指向空
        fast, slow = head, head
        s_pre = None
        while fast and fast.next:
            s_pre = slow
            slow = slow.next
            fast = fast.next.next
        s_pre.next = None

        # 反转链表，最终头指针为pre
        pre = None
        while slow:
            lat = slow.next
            slow.next = pre
            pre = slow
            slow = lat

        # 两个链表结点值交替添加
        cur = head
        while cur.next:
            tmp = cur.next
            cur.next = pre
            pre = pre.next
            cur.next.next = tmp
            cur = tmp
        cur.next = pre