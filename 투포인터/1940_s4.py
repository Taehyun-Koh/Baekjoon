import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

arr = list(map(int,input().split()))
arr.sort()
a = 0
b = n-1

answer = 0
while a<b:
    if arr[a] + arr[b] < m:
        a += 1
    elif arr[a] + arr[b] > m:
        b -= 1
    else:
        a += 1
        b -= 1
        answer += 1
print(answer)
