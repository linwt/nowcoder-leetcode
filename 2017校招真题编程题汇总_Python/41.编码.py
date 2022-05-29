s = raw_input()
n1 = 25**3+25**2+25+1
n2 = 25**2+25+1
n3 = 25+1
n4 = 1
n = [n1,n2,n3,n4]
count = len(s)-1
for i in range(len(s)):
    count += n[i]*(ord(s[i])-ord('a'))
print(count)