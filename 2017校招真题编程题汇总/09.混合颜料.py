# 进行行与行之间的xor，其中1^1=0;  0^0=0;  1^0=1; 0^1=1;

# 矩阵的秩定义：是其行向量或列向量的极大无关组中包含向量的个数。
# 矩阵的秩求法：用初等行变换化成梯矩阵, 梯矩阵中非零行数就是矩阵的秩

# 问题理解：输入n个数，将这些数之间进行多次xor（异或操作），其中一个数可能被xor多次，看最后能剩余多少不重复的数，输出数量即可。
# 思路：类似矩阵求秩，首先将各数从大到小排序,对位数与该行相同的进行异或操作

# 具体过程如下：
#      排序 i=0      异或      排序 i=1    异或      排序 i=2
# 101010 --> 111010 --> 111010 --> 111010 --> 111010 --> 111010
# 111010 --> 110110 --> 001100 --> 010111 --> 010111 --> 010111
# 101101 --> 101101 --> 010111 --> 010000 --> 000111 --> 001100
# 110110 --> 101010 --> 010000 --> 001100 --> 001100 --> 000111

n = int(raw_input())
X = map(int, raw_input().split())
for i in range(n-1,0,-1):
    X.sort()
    for j in range(i-1,-1,-1):
        if X[i]^X[j] < X[j]:
            X[j] ^= X[i]
for i in range(n):
    if X[i]!=0:
        print (n-i)
        break