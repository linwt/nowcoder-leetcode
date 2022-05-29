# 各条件逐一判断
s = raw_input()
res = 'Likes'
if not s.isupper():
    res = 'Dislikes'
for i in range(len(s)-1):
    if s[i] == s[i+1]:
        res = 'Dislikes'
for i in range(len(s)-3):
    if s[i] == s[i+2] and s[i+1] == s[i+3]:
        res = 'Dislikes'
print(res)