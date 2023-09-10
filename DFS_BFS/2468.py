import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
n = int(input())
maps = []
for _ in range(n):
    maps.append(list(map(int,input().split())))

dx = [0,0,-1,1]
dy = [-1,1,0,0]

minv = 101
maxv = 0
for i in range(n):
    for j in range(n):
        minv = min(maps[i][j], minv)
        maxv = max(maps[i][j], maxv)


def dfs(x,y):
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        
        if 0<=nx<n and 0<=ny<n:
            if tmp[nx][ny] != 0:
                tmp[nx][ny] = 0
                dfs(nx,ny,)

ans = 1
for t in range(minv,maxv):
    tmp = [[0]*n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            tmp[i][j] = maps[i][j]
            if tmp[i][j] <= t:
                tmp[i][j] = 0

    ansv = 0
    for i in range(n):
        for j in range(n):
            if tmp[i][j] != 0:
                tmp[i][j] = 0
                ansv += 1
                dfs(i,j)

    ans = max(ans,ansv)

print(ans)

            
    