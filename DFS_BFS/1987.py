import sys
from collections import deque
input = sys.stdin.readline
visited = [0] * 26

dx = [1,-1,0,0]
dy = [0,0,-1,1]

r,c = map(int,input().split())

maps = []
dis = []
for i in range(r):
    tmp = list(input().strip())
    tmp2 = [0] * c
    maps.append(tmp)
    dis.append(tmp2)
    

q = deque()
q.append([0,0])
visited[ord(maps[0][0])-65] = 1
dis[0][0] = 1

def dfs(x,y):
    
    
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        
        if 0<=nx<r and 0<=ny<c:
            if visited[ord(maps[nx][ny])-65] == 0:
                visited[ord(maps[nx][ny])-65] = 1
                dis[nx][ny] = dis[x][y] + 1
                
                dfs(nx,ny)
                visited[ord(maps[nx][ny])-65] = 0

dfs(0,0)


ans = 0
for i in range(len(dis)):
    for j in range(len(dis[i])):
        ans = max(ans,dis[i][j])

print(ans)