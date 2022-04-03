// 146. LRU 缓存


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/*
1、LRU：最近最久未使用，缓存淘汰算法
2、LinkedHashMap 哈希链表 = 双向链表 + 哈希表
  1）哈希表：查找快，但是无序
  2）链表：有序，插入、删除快，但是查找慢
 */


// 使用Java的API LinkedHashMap
class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // 删除最近最久未使用节点
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > capacity;
    }
}


/*
LRUCache类，即手动实现哈希链表、缓存淘汰机制：
1、定义 双向链表节点内部类，包含 公有成员变量“键、值、前驱节点、后驱节点”、构造方法
2、定义 私有成员变量“HashMap缓存、链表大小、链表容量、链表头尾哨兵节点”
3、定义 公有构造方法，初始化成员变量
4、定义 私有方法，处理链表节点，添加节点到头部、删除节点、移动节点到头部、删除尾部节点
5、实现获取节点值
  1）根据key从缓存中获取节点
  2）如果节点不存在，返回-1
  3）如果节点存在，当前被使用了，移动节点到头部
6、实现存入节点
  1）根据key从缓存中获取节点
  2）如果节点不存在
    ① 创建节点、添加节点到缓存、添加节点到头部、链表大小加1
    ② 判断链表大小是否超过链表容量，超过则 删除尾部节点、删除该节点缓存、链表大小减1
  3）如果节点存在，更新节点值、移动节点到头部
 */
class LRUCache {
    // 内部类，双向链表节点
    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        public DoubleLinkedNode() {}

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();    // 缓存
    private int size;   // 大小
    private int capacity;   // 容量
    private DoubleLinkedNode head, tail;    // 头尾哨兵节点

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // 获取节点值
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    // 存入节点
    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            this.size++;
            if (this.size > this.capacity) {
                DoubleLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                this.size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    // 添加节点到头部
    private void addToHead(DoubleLinkedNode node) {
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }

    // 删除节点
    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 移动节点到头部：删除节点、添加节点到头部
    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾部节点
    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = this.tail.prev;
        removeNode(node);
        return node;
    }
}