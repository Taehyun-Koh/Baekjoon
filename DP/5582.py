import sys
input = sys.stdin.readline

a = list(input().strip())
b = list(input().strip())

dp = [[0]*len(a) for _ in range(len(b))]

maxv = 0
for i in range(len(b)):
    for j in range(len(a)):
        if i == 0 or j == 0:
            if b[i] == a[j]:
                dp[i][j] = 1
        else:
            if b[i] == a[j]:
                dp[i][j] = dp[i-1][j-1] + 1
                maxv = max(maxv, dp[i][j])

print(maxv)
                