import sys
sys.setrecursionlimit(10000)

def dfs(x,y):
    dx = [1,-1,0,0]
    dy = [0,0,-1,1]
    
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        
        if (0<=nx<n) and (0<=ny<m):
            if graph[nx][ny] == 1:
                graph[nx][ny] -= 1
                dfs(nx,ny)
            
t = int(input())

for _ in range(t):
    m,n,k = map(int,input().split())
    
    graph = [[0]*m for _ in range(n)]
    result = 0 
    
    for _ in range(k):
        a,b = map(int,input().split())
        graph[b][a] = 1
    
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                dfs(i,j)
                result += 1
    print(result)