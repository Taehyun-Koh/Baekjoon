import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int,input().split(' ')))

answer = [-1] * n
stack = []

for i in range(n):
    if i == 0:
        stack.append(0)
        continue
    while stack and arr[stack[-1]] < arr[i]:
        answer[stack.pop()] = arr[i]
    stack.append(i)

print(*answer)
## 1시간 풀이 o