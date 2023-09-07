import sys
from collections import deque
input = sys.stdin.readline

n,m,k = map(int,input().split())

maps = []
dx = [0,0,-1,1]
dy = [-1,1,0,0]
for _ in range(n):
    maps.append([0] * m)
    
for i in range(k):
    a,b = map(int,input().split())
    maps[a-1][b-1] = 1
    
answer = 0

q = deque()

for i in range(n):
    for j in range(m):
        if maps[i][j] == 1:
            tmp = 1
            
            q.append([i,j])
            
            
            while q:
                
                x,y = q.popleft()
                maps[x][y] = 0
                for k in range(4):
                    nx = dx[k] + x
                    ny = dy[k] + y
                    
                    if 0<=nx<n and 0<=ny<m:
                        if maps[nx][ny] == 1:
                            tmp += 1
                            maps[nx][ny] = 0
                            q.append([nx,ny])
            answer = max(tmp,answer)
            
print(answer)
                        
