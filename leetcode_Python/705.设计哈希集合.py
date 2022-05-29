class MyHashSet(object):

    def __init__(self):
        self.hash = set()

    def add(self, key):
        self.hash.add(key)

    def remove(self, key):
        if self.contains(key):
            self.hash.remove(key)

    def contains(self, key):
        if key in self.hash:
            return True
        return False