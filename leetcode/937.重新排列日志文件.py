# 将字母日志和数字日志分开，字母日志排序后，再组合在一起
class Solution(object):
    def reorderLogFiles(self, logs):
        digit, letter = [], []
        for log in logs:
            if log.split()[1].isdigit():
                digit.append(log)
            else:
                letter.append(log)
        letter.sort(key=lambda x: x.split()[1:])
        return letter + digit