# 方法一：先将链表A的结点存放在字典中，遍历链表B，如果该结点已在字典中，则为相交起始结点
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        d = dict()
        while headA:
            d[headA] = 1
            headA = headA.next
        while headB:
            if headB in d:
                return headB
            headB = headB.next
        return None

# 方法二：遍历并得到两个链表的长度差值，较长者先移动使得剩余长度一致，再判断两个链表的结点是否相同，相同则为相交起始结点
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        def getLength(head):
            length = 0
            while head:
                length += 1
                head = head.next
            return length

        a = getLength(headA)
        b = getLength(headB)
        if a>b:
            for _ in range(a-b):
                headA = headA.next
        else:
            for _ in range(b-a):
                headB = headB.next

        while headA != headB:
            headA, headB = headA.next, headB.next
        return headA

# 方法三：使用两个指针都遍历两个链表，由于走的长度一致，最终会在某点相遇，该点就是相交起始结点
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        if not headA or not headB:
            return None

        A, B = headA, headB
        while A and B and A!=B:
            A, B = A.next, B.next
            if A==B:
                return A
            if not A:
                A = headB
            if not B:
                B = headA
        return A