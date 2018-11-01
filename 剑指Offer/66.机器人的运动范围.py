# 使用字典
class Solution:
    def movingCount(self, threshold, rows, cols):
        global d
        d={}
        return self.stat(0,0,threshold, rows, cols)
    def stat(self,row,col,threshold,rows,cols):
        # 1个方格的情况
        if row/10 + row%10 + col/10 + col%10 > threshold:
            return 0
        if row<0 or row>=rows or col<0 or col>=cols :
            return 0
        if d.get((row,col)):
            return 0
        else:
            d[(row,col)]=1
        # 2到多个方格的情况
        return 1+self.stat(row+1,col,threshold,rows,cols)+self.stat(row-1,col,threshold,rows,cols)+self.stat(row,col+1,threshold,rows,cols)+self.stat(row,col-1,threshold,rows,cols)

# 使用数组
class Solution:
    def __init__(self):
        self.arr = []
    def movingCount(self, threshold, rows, cols):
        return self.stat(0, 0, threshold, rows, cols)
    def stat(self, row, col, threshold, rows, cols):
        if row/10 + row%10 + col/10 + col%10 > threshold:
            return 0
        if row<0 or row>=rows or col<0 or col>=cols:
            return 0
        if (row,col) in self.arr:
            return 0
        else:
            self.arr.append((row,col))
        return 1 + self.stat(row+1, col, threshold, rows, cols) + self.stat(row-1, col, threshold, rows, cols) + self.stat(row, col+1, threshold, rows, cols) + self.stat(row, col-1, threshold, rows, cols)