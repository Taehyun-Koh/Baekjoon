import sys
from collections import deque

R,C = map(int,input().split())

## R 행 / C 열
maps = [list(map(str, input().strip())) for _ in range(R)]

dx = [0,0,-1,1]
dy = [-1,1,0,0]
waterq = deque()

for i in range(R):
    for j in range(C):
        if maps[i][j] == 'D':
            d = (i,j)
        if maps[i][j] == '*':
            waterq.append((i,j,0))
        if maps[i][j] == 'S':
            s = (i,j,0)

waterMap = [[0]*C for _ in range(R)]
visited = [[0]*C for _ in range(R)]


q = deque()
q.append(s)

def waterBFS():
    
    while waterq:
        
        x,y,time = waterq.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx<R and 0<=ny<C:
                if maps[nx][ny] == '.' and waterMap[nx][ny] == 0:
                    waterMap[nx][ny] = time+1
                    waterq.append((nx,ny,time+1))
                    
waterBFS()

def BFS():
    

    while q:
        # print(q)

        x,y,time = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx<R and 0<=ny<C:
                
                if maps[nx][ny] == 'D':
                    visited[nx][ny] = time + 1
                    print(visited[nx][ny])
                    return
                
                if maps[nx][ny] == '.' and visited[nx][ny] == 0 :
                    if waterMap[nx][ny] > time+1 or waterMap[nx][ny] == 0:
                        visited[nx][ny] = time+ 1
                        q.append((nx,ny,time+1))

                    
BFS()

# for i in visited:
#     print(i)
# print('\n')  

# for i in waterMap:
#     print(i)
if visited[d[0]][d[1]] == 0:
    print('KAKTUS')    
                