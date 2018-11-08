# 由每个单词独有的字母求出该数有几个
n=int(raw_input())
data=[]
for i in range(n):
    data.append(raw_input())
for d in data:
    zero=d.count('Z')
    two=d.count('W')
    four = d.count('U')
    six = d.count('X')
    eight = d.count('G')

    one = d.count('O') - zero - two - four
    three = d.count('H') - eight
    five = d.count('F') - four
    seven = d.count('V') - five
    nine = d.count('I')-six-five-eight
    print('0'*eight + '1'*nine + '2'*zero + '3'*one + '4'*two + '5'*three + '6'*four + '7'*five + '8'*six + '9'*seven)