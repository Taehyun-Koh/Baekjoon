import sys
from collections import deque
input = sys.stdin.readline

R,C,N = map(int,input().split())

dx = [-1,1,0,0]
dy = [0,0,-1,1]

maps = []
for r in range(R):
    maps.append(list(input().strip()))

bomb = deque()
for r in range(R):
    for c in range(C):
        if maps[r][c] == '.':
            maps[r][c] = -1
        else:
            maps[r][c] = 1

time = 1


while time < N:
    
    q = deque()
    for r in range(R):
        for c in range(C):
            maps[r][c] += 1
            if maps[r][c] == 3:
                q.append([r,c])

    while q:
        x,y = q.popleft()
        maps[x][y] = -1
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            
            if 0<=nx<R and 0<=ny<C:
                maps[nx][ny] = -1
                
    time += 1
    
    
for r in range(R):
    x = ''
    for c in range(C):
        if maps[r][c] != -1:
            x += 'O'
        else:
            x += '.'
    print(x)