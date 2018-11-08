# 设f(x)=4x+3,g(x)=8x+7。计算可以得到以下两个规律：
# （1）  g(f(x))=f(g(x))   即f和g的执行顺序没有影响。
# （2）  f(f(f(x)))=g(g(x))   即做3次f变换等价于做2次g变换
#  由于规律（1），可以调整其变换的顺序。如ffggfggff可以转化成 fffffgggg
#  由于规律（2），为了使执行次数最少，每3个f可以转化成2个g。如fffffgggg可以转化成ffgggggg。
#  因此一个最优的策略，f的执行次数只能为0,1,2。对于输入的x，只需要求x，4x+3,4（4x+3）+3的最小g执行次数就可以了。
x = int(raw_input())
num = 100001
base = [x, 4*x+3, 4*(4*x+3)+3]
for i,v in enumerate(base):
    for j in range(100000):
        v = (8*v+7)%1000000007
        if v == 0:
            num = min(num, i+j+1)
            break
if num == 100001:
    print(-1)
else:
    print(num)


# 4x+3相当于做了两次2x+1， 8x+7做了三次。
# 从起点开始令x0 = 2*x0+1，统计做了多少次2x+1后模1000000007等于0
# 再把次数分解成若干个3与2的和，3的个数加上2的个数最小，不超过100000
x = int(raw_input())
r = 0
while x!=0 and r<=300000:
    x = (2*x+1)%1000000007
    r += 1
s = (r+2)/3
print -1 if s>10**5 else s