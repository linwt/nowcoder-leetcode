// 208. 实现 Trie (前缀树)


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


/*
前缀树：
1、创建前缀结点内部类 TrieNode
  1）成员变量 isEnd 表示结点是否叶子结点，用于搜索时判断是否搜索结束
  2）字母映射表 next 保存了对当前结点而言下一个可能出现的所有字符的引用，因此可以通过一个父结点来预知它所有子结点的值
    Trie 中一般都含有大量的空引用，因此在绘制一棵单词查找树时一般会忽略空引用
  3）构造函数，对成员变量 isEnd、next 赋值初始化
2、设计前缀树
  1）成员变量前缀结点 root，作为单词树的入口，方便构造和查找
  2）构造函数对成员变量root初始化
  3）插入：向 Trie 中插入一个单词 word
         这个操作和构建链表很像。首先从根结点的子结点开始与 word 第一个字符进行匹配，一直匹配到前缀链上没有对应的字符，
         这时开始不断创建新的结点，直到插入完 word 的最后一个字符，同时还要标记最后一个结点 isEnd=true，表示它是一个单词的末尾
  4）单词查找：查找 Trie 中是否存在单词 word
            从根结点的子结点开始，一直向下匹配，如果出现结点值为空就返回 false，如果匹配到了最后一个字符，再判断结点是否单词末尾返回是否存在单词
  5）前缀查找：判断 Trie 中是否有以 prefix 为前缀的单词
            和 search 操作类似，但只要匹配到最后一个字符，就说明存在该前缀的单词

sea、sell、she
     s
    /  \
   e    h
  / \   |
 a   l  e
     |
     l
 */
class Trie {

    class TrieNode {
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}