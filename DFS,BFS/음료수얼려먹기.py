import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(x,y):
    dx = [1,-1,0,0]
    dy = [0,0,-1,1]
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if (0<=nx<n) and (0<=ny<m):
            if graph[nx][ny] == 0:
                graph[nx][ny] = 1
                dfs(nx,ny)

n,m = map(int,input().split())
graph = [list(map(int,input().strip())) for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            cnt += 1
            dfs(i,j)

print(cnt)