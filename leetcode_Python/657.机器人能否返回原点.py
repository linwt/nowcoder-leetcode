# 方法一：横轴、纵轴方向记录移动位置
class Solution(object):
    def judgeCircle(self, moves):
        x = y = 0
        for i in moves:
            if i == 'L':
                x -= 1
            elif i == 'R':
                x += 1
            elif i == 'U':
                y += 1
            else:
                y -= 1
        if x==0 and y==0:
            return True
        return False

# 方法二：统计左与右、上与下的个数是否相等
class Solution(object):
    def judgeCircle(self, moves):
        return moves.count('L') == moves.count('R') and moves.count('U') == moves.count('D')