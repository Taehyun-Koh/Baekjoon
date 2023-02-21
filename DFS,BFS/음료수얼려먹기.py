import sys
input = sys.stdin.readline

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
        

n,m = map(int,input().split(' '))
graph = []
for i in range(n):
    graph.append(list(map(int,input().strip())))
    
result = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            result += 1
            dfs(i,j)
print(result)