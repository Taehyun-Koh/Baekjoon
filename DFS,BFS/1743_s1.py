import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

def dfs(x,y):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0<=nx<n and 0<=ny<m:
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                global tmp
                tmp += 1
                dfs(nx,ny)

n,m,k = map(int,input().split())

graph = [[0]*m for _ in range(n)]

for _ in range(k):
    a,b = map(int, input().split())
    graph[a-1][b-1] = 1

answer = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            tmp = 0
            dfs(i,j)
            answer = max(tmp,answer)
print(answer)

# 풀이 x 30분