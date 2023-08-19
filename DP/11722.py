import sys
input = sys.stdin.readline

n = int(input())
tmp = list(map(int,input().split()))
arr = []
for i in range(n-1,-1,-1):
    arr.append(tmp[i])
    
dp = [1] *n

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)
            
print(max(dp))