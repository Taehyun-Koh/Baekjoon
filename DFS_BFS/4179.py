import sys
input = sys.stdin.readline
from collections import deque

R,C = map(int,input().split())
dx = [0,0,-1,1]
dy = [-1,1,0,0]
# R 행 / C 열 개수
maps = []
jihoon = []
for r in range(R):
    maps.append(list(input().strip()))
    jihoon.append([0] * C)

start = deque()
fire = deque()
for r in range(R):
    for c in range(C):

        if maps[r][c] == "#":
            maps[r][c] = -1
            jihoon[r][c] = -1
        elif maps[r][c] == "J":
            jihoon[r][c] = 1
            maps[r][c] = 0
            start.append([r,c,1])
        elif maps[r][c] == 'F':
            fire.append([r,c,1])
            maps[r][c] = 1
        else:
            jihoon[r][c] = 0
            maps[r][c] = 0

while fire:
    x,y,time = fire.popleft()
    
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        
        if 0<=nx<R and 0<=ny<C:
            if maps[nx][ny] != -1 and maps[nx][ny] == 0:
                # if maps[nx][ny] == '.' or maps[nx][ny] == 'J':
                    maps[nx][ny] = time + 1
                    fire.append([nx,ny,time+1])

# for x in maps:
#     print(x)
    

imp = False

while start:
    x,y,time = start.popleft()
    
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        
        if 0<=nx<R and 0<=ny<C:
            if jihoon[nx][ny] == 0:
                if jihoon[x][y] + 1 < maps[nx][ny] or maps[nx][ny] == 0:
                    jihoon[nx][ny] = jihoon[x][y] + 1
                    start.append([nx,ny,time+1])

                
minv = 999999999999999
for r in range(R):
    for c in range(C):
        if 0<r<R-1 and 0<c<C-1:
            continue
        if jihoon[r][c] != -1 and jihoon[r][c] != 0:
            minv = min(minv, jihoon[r][c])

if minv == 999999999999999:
    print("IMPOSSIBLE")
else:
    print(minv)
            
