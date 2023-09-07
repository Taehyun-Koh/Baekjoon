import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
dp = [[0 for _ in range(21)] for _ in range(n)]

dp[0][arr[0]] = 1

for i in range(1,n-1):
    for j in range(21):
        if dp[i-1][j]:
            # 덧셈일 경우
            if 0 <= j+arr[i] <= 20:
                dp[i][j+arr[i]] += dp[i-1][j]
            
            # 뺼셈일 경우
            if 0 <= j-arr[i] <= 20:
                dp[i][j-arr[i]] += dp[i-1][j]
    for x in dp:
        print(x)
    print()