import sys
input = sys.stdin.readline

s = list(input().strip())
a = s.count('a')

ans = 999999999999999

left = 0

while left < len(s):
    right = left + a
    if right > len(s):
        tmp = s[left : len(s)] + s[:right-len(s)]
    else:
        tmp = s[left:right]
    ans = min(ans, tmp.count('b'))
    left += 1

print(ans)
    