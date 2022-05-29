# 使用全局变量作为标记
class Foo(object):
    def __init__(self):
        self.flag = 1

    def first(self, printFirst):
        printFirst()
        self.flag = 2

    def second(self, printSecond):
        while self.flag != 2:
            pass
        printSecond()
        self.flag = 3

    def third(self, printThird):
        while self.flag != 3:
            pass
        printThird()