class Solution(object):
    def toLowerCase(self, str):
        # return str.lower()
        return ''.join(chr(ord(c) + 32) if 'A' <= c <= 'Z' else c for c in str)