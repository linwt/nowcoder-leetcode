# 方法一
class Solution(object):
    def reverseKGroup(self, head, k):
        h = ListNode(-1)
        h.next = head
        pre = h
        cur = head

        while cur:
            t = cur
            count = 1
            # 遍历k个为一组
            while count<k and t:
                t = t.next
                count += 1
            # 凑够一组进行翻转
            if count==k and t:
                # 每次将当前结点的后一个结点移到该组的最前面
                for _ in range(k-1):
                    lat = cur.next
                    cur.next = lat.next
                    lat.next = pre.next
                    pre.next = lat
                pre = cur
                cur = cur.next
            # 凑不够一组则结束
            else:
                break
        return h.next

# 方法二：递归
class Solution(object):
    def reverseKGroup(self, head, k):
        h = ListNode(-1)
        h.next = head
        pre = h
        cur = head
        t = 1
        while cur:
            if t % k == 0:
                pre = self._reverseGroup(pre, cur.next)
                cur = pre.next
            else:
                cur = cur.next
            t += 1
        return h.next

    def _reverseGroup(self, pre, lat):
        lpre = pre.next
        cur = lpre.next
        # 每次将cur指向的结点移到该组最前面，然后cur指针再指向下一个结点
        while cur != lat:
            lpre.next = cur.next
            cur.next = pre.next
            pre.next = cur
            cur = lpre.next
        return lpre