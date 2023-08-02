
N,M,K = map(int,input().split())

dp = [[0] * (M+1) for _ in range(N+1)]

res = ''

def getdp(n,m):
    if dp[n][m] != 0:
        return dp[n][m]
    if n == 0 or m == 0:
        return 1
    
    dp[n][m] = getdp(n,m-1) + getdp(n-1,m)
    return dp[n][m]


def getRes(a,z,k):
    global res
    if a == 0:
        for i in range(z):
            res += 'z'
        return
    if z == 0:
        for _ in range(a):
            res += 'a'
        return
    tmp = getdp(a-1,z)
    if tmp<k: ## 앞이 z로 시작
        res += 'z'
        getRes(a,z-1,k-tmp)
        
    else: ## 앞이 a로 시작
        res += 'a'
        getRes(a-1, z, k)
        


if getdp(N,M) < K:
    print(-1)
else:
    getRes(N,M,K)    
    print(res)