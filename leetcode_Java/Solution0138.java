// 138. 复制带随机指针的链表


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


/*
递归：
1、成员变量 map 存放新旧节点的映射关系 {原节点：新节点}
2、定义递归函数
  1）方法功能：入参是一个节点，map存在则直接获取返回，否则拷贝该节点并存入map中，返回拷贝节点
  2）终止条件：节点为空时返回空
  3）返回结果：返回该节点的拷贝节点
  4）递归逻辑：拷贝节点的next指针和random指针需要连接新的拷贝节点，因此调用同样的方法，传入原节点的下一节点和随机节点进行拷贝并返回
 */
class Solution {
    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}


/*
迭代：
1、在每个原节点后面创建一个新节点
2、设置新节点的随机节点
3、将两个链表分离

1 → 2 → 3
=====================
1 → 1 → 2 → 2 → 3 → 3
=====================
------------
↑          ↓
1    1  →  2  →  2  →  3  →  3
  ↗ cur    p
0

 */
class Solution {
    public Node copyRandomList(Node head) {
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;
        Node root = new Node(0);
        Node cur = root;
        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = p.next.next;
            p = p.next;
        }
        return root.next;
    }
}


/*
哈希表：
1、创建一个哈希表，再遍历原链表，遍历的同时再不断创建新节点，将原节点作为key，新节点作为value放入哈希表中，原节点和新节点是一一对应的关系，即
   map.get(原节点)，得到的就是对应的 新节点
   map.get(原节点.next)，得到的就是对应的 新节点.next
   map.get(原节点.random)，得到的就是对应的 新节点.random
2、再遍历原链表，设置新链表的next和random指针
   新节点.next -> map.get(原节点.next)
   新节点.random -> map.get(原节点.random)
 */
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node newNode = map.get(p);
            if (p.next != null) {
                newNode.next = map.get(p.next);
            }
            if (p.random != null) {
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }
}