class Solution(object):
    def tree2str(self, t):
        if not t:
            return ''
        res = str(t.val)
        if t.left and t.right:
            return res + '(' + self.tree2str(t.left) + ')' + '(' + self.tree2str(t.right) + ')'
        # 可省略空括号
        if t.left and not t.right:
            return res + '(' + self.tree2str(t.left) + ')'
        # 不可省略空括号
        if not t.left and t.right:
            return res + '()(' + self.tree2str(t.right) + ')'
        return res