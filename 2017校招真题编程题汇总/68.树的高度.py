n = int(raw_input())
# {结点：[总高度，子结点数]}
tree = {'0':[1, 0]}
for _ in range(n-1):
    father, child = raw_input().split()
    if father in tree and tree[father][1]<2:
        tree[father][1] += 1
        tree[child] = [tree[father][0]+1, 0]
print(max(node[0] for node in tree.values()))