class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        if not n:
            return True

        lens = len(flowerbed)
        i = 0
        while i < lens:
            # 当前为0，前一个已经为0，只需判断后一个是否为0
            if flowerbed[i] == 0:
                # 后一个为0，则当前可种花，走两步判断下一个位置
                if i < lens-1 and flowerbed[i+1] == 0:
                    n -= 1
                    if not n:
                        break
                    i += 2
                # 后一个为1，则当前不可种花，走三步判断下一个位置
                elif i < lens-1 and flowerbed[i+1] == 1:
                    i += 3
                # 当前是最后一个，由于前面是0，故当前可种花
                elif i == lens-1:
                    n -= 1
                    break
            # 当前为1, 1后肯定是0，走两步判断下一个位置
            else:
                i += 2

        if not n:
            return True
        return False