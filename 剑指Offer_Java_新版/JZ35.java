// 35. 复杂链表的复制


public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        // 复制全部结点
        RandomListNode head = pHead;
        while (head != null) {
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        // 连接结点关系
        head = pHead;
        while (head != null) {
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return map.get(pHead);
    }
}
