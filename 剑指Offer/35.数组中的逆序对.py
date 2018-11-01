# 方法一：归并排序
class Solution:
    def InversePairs(self, data):
        return self.inverseCount(data[:], 0, len(data)-1, data[:])%1000000007

    def inverseCount(self, tmp, start, end, data):
        if end-start <1:
            return 0
        if end - start == 1:
            if data[start]<=data[end]:
                return 0
            else:
                tmp[start], tmp[end] = data[end], data[start]
                return 1
        mid = (start+end)//2
        count = self.inverseCount(data, start, mid, tmp) + self.inverseCount(data, mid+1, end, tmp)
        i = start
        j = mid + 1
        ind = start
        while(i <= mid and j <= end):
            if data[i] <= data[j]:
                tmp[ind] = data[i]
                i += 1
            else:
                tmp[ind] = data[j]
                count += mid - i + 1
                j += 1
            ind += 1
        while(i<=mid):
            tmp[ind] = data[i]
            i += 1
            ind += 1
        while(j<=end):
            tmp[ind] = data[j]
            j += 1
            ind += 1
        return count

# 方法二：暴力破解。算法复杂度偏大
class Solution:
    def InversePairs(self, data):
        count = 0
        for i in range(len(data)-1):
            for j in range(i+1, len(data)):
                if data[i] > data[j]:
                    count += 1
        return count%1000000007

# 方法三：最小元素前有几个数字就有几个逆序对，移除最小元素后，在剩余数组中再重复以上步骤。算法复杂度偏大。
class Solution:
    def InversePairs(self, data):
        count = 0
        copy = [i for i in data]
        copy.sort()
        for i in range(len(copy)):
            count += data.index(copy[i])
            data.remove(copy[i])
        return count%1000000007