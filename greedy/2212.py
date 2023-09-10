import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
arr = list(map(int,input().split()))
arr.sort()

diff = []

for i in range(1,len(arr)):
    diff.append(arr[i] - arr[i-1])

diff.sort()

ans = 0
for i in range(n-k):
    ans += diff[i]
    
print(ans)
