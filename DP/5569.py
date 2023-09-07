w,h = map(int,input().split())

dp = [[[[0 for _ in range(2)] for _ in range(2)] for _ in range(101)] for _ in range(101)]

#앞의 0,1은 방향전환 가능여부, 뒤의 0,1은 북/동 방향 어딜 일직선 통과

for i in range(2,h+1):
    dp[i][1][0][0] = 1
for i in range(2,w+1):
    dp[1][i][0][1] = 1
    
for i in range(2,h+1):
    for j in range(2, w+1):
        dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][1][0]) % 100000
        dp[i][j][0][1] = dp[i][j-1][0][1] + dp[i][j-1][1][1] % 100000
        dp[i][j][1][0] = dp[i-1][j][0][1] % 100000
        dp[i][j][1][1] = dp[i][j-1][0][0] % 100000
        
print((dp[h][w][0][0] + dp[h][w][1][0] + dp[h][w][0][1] + dp[h][w][1][1])%100000)