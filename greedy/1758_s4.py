import sys
input = sys.stdin.readline

n = int(input())
tip = [int(input()) for i in range(n)]

tip.sort(reverse=True)
result = 0
for i in range(n):
    tip[i] = tip[i] - (i)
    if tip[i] >=0:
        result+=tip[i]
print(result)


# 풀이 x 5분