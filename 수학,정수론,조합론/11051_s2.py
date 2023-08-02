
import sys
sys.setrecursionlimit(10**5)
n,k = map(int,input().split())



dp = [[0]*(k+1) for _ in range(n+1)]

def nCr(n,k):
    if n==k or k==0:
        return 1
    if n==0:
        return 0
    if dp[n][k] != 0:
        return dp[n][k]
    
    dp[n][k] = nCr(n-1,k-1) + nCr(n-1,k)
    return dp[n][k] % 10007


print(nCr(n,k))