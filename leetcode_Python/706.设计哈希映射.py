class MyHashMap(object):

    def __init__(self):
        self.d = {}

    def put(self, key, value):
        self.d[key] = value

    def get(self, key):
        if key in self.d:
            return self.d[key]
        return -1

    def remove(self, key):
        if key in self.d:
            del self.d[key]