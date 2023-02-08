import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split(" ")))
dp = [0] * (n+1)
long = 0
# 5 2 4 1 3
# 0 0 0 0 0 5
for i in range(n):
    idx = arr[i]
    dp[idx] = dp[idx-1] + 1
    print(dp, idx, dp[idx], dp[idx-1] + 1)
    long = max(dp[idx], dp[idx - 1] + 1)
        
print(n-long)

## 풀이참고 dp