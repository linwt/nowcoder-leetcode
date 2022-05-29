# 方法一：数组存储链表结点值
class Solution:
    def FindKthToTail(self, head, k):
        l = []
        while head:
            l.append(head)
            head = head.next
        if k>len(l) or k<1:
            return None
        return l[-k]

# 方法二：使用两个指针
# 两个指针指向head，第一个指针先走k步。然后两个指针同时往后移，当第一个指针到达末尾时，第二个指针即在倒数第k个结点
class Solution:
    def FindKthToTail(self, head, k):
        front, later = head, head
        for i in range(k):
            if not front:
                return
            if not front.next and i==k-1:
                return head
            front = front.next
        while front.next:
            front = front.next
            later = later.next
        return later.next