import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
arr.sort()

if n%2 == 0:
    minv = 0
    for i in range(n//2):
        minv = max(minv,arr[i] + arr[n-i-1])
else:
    minv = arr.pop()
    for i in range(n//2):
        minv = max(minv, arr[i]+ arr[n-i-2])

print(minv)