# 用数组模拟
class MyLinkedList(object):

    def __init__(self):
        self.arr = []

    def get(self, index):
        if index > len(self.arr)-1 or index < 0:
            return -1
        return self.arr[index]

    def addAtHead(self, val):
        self.arr.insert(0, val)

    def addAtTail(self, val):
        self.arr.append(val)

    def addAtIndex(self, index, val):
        if index == len(self.arr):
            self.arr.append(val)
        elif index > len(self.arr) or index < 0:
            return
        else:
            self.arr.insert(index, val)

    def deleteAtIndex(self, index):
        if index > len(self.arr)-1 or index < 0:
            return
        self.arr.pop(index)
