# 广度优先搜索
class Solution(object):
    def canVisitAllRooms(self, rooms):
        queue = rooms[0]
        visit = [0]
        while queue:
            temp = queue.pop()
            if temp in visit:
                continue
            queue += rooms[temp]
            visit.append(temp)
        return len(visit) == len(rooms)


# 深度优先搜索
class Solution2(object):
    def canVisitAllRooms(self, rooms):
        def dfs(room):
            # 将当前房间添加到钥匙集合
            keys.add(room)
            # 遍历当前房间里的钥匙
            for key in rooms[room]:
                # 若该钥匙未在集合中
                if key not in keys:
                    # 则递归搜索对应房间内的钥匙
                    dfs(key)

        keys = set()
        dfs(0)
        return len(keys) == len(rooms)