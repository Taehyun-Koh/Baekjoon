import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

def dfs(x,y):

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0<=nx<n and 0<=ny<n:
            if graph[nx][ny] == 1:
                global cnt
                cnt += 1
                graph[nx][ny] = 0
                dfs(nx,ny)


n = int(input())
graph = [list(map(int,input().strip())) for _ in range(n)]

result = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            graph[i][j] = 0
            cnt = 1
            dfs(i,j)
            result.append(cnt)
            

result.sort()
print(len(result) ,*result)
            
# 풀이 x 15분
