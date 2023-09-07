import sys
input = sys.stdin.readline

n = int(input())

arr = []
dp = []
for i in range(n):
    arr.append(list(map(int,input().split())))
    dp.append(list([0] *(i+1)))



ans = 0
dp[0][0] = arr[0][0]
if n == 1:
    print(arr[0][0])
    sys.exit()
dp[1][0] = dp[0][0] + arr[1][0]
dp[1][1] = dp[0][0] + arr[1][1]

for i in range(2,n):
    
    for j in range(i+1):
        # print(i,j, arr[i][j])
        index = j // 2
        if j == 0:
            dp[i][j] = dp[i-1][j] + arr[i][j]
        elif j == i:
            dp[i][j] = dp[i-1][-1] + arr[i][j]
        else:
                dp[i][j] = arr[i][j] + max(dp[i-1][j-1], dp[i-1][j])
        # for x in dp:
        #     print(x)
print(max(dp[n-1]))