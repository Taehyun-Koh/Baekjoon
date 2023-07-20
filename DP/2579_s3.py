import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))
    
dp = [0] * (n+1)
dp[1] = arr[0]
dp[2] = arr[1]

for i in range(3, n+1):
    if dp[i] > dp[i-1]:
        dp[i] = dp[i-2] + dp[i]
    

