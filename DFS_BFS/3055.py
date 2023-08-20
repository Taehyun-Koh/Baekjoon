from collections import deque

import sys
input = sys.stdin.readline


dx = [0,0,-1,1]
dy = [-1,1,0,0]

## R 행 // C 열

R,C = map(int,input().split())

maps = []
visitedW = []
visited = []
for i in range(R):
    maps.append(list(map(str,input().strip())))
    visitedW.append([0] * C)
    visited.append([0] * C)

D = []
S = []
W = []

for i in range(R):
    for j in range(C):
        if maps[i][j] == 'D' : D = [i,j]
        elif maps[i][j] == 'S' : S = [i,j,0]
        elif maps[i][j] == '*' : W.append([i,j,0])


wq = deque(W)

while wq:

    x,y,time = wq.popleft()
    
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        
        if (0<=nx<R and 0<=ny<C):
            if maps[nx][ny] == "." and visitedW[nx][ny] == 0:
                visitedW[nx][ny] = time+1
                wq.append([nx,ny,time+1])            

# for i in visitedW:
#     print(i)
# print("\n")
q = deque()
q.append(S)
visited[S[0]][S[1]] = 0
while q:
    x,y,time = q.popleft()
    
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        
        if (0<=nx<R and 0<=ny<C):
            if maps[nx][ny] == "D" :
                visited[nx][ny] = time + 1
                q.clear()
                break
            elif maps[nx][ny] == '.' and visited[nx][ny] == 0:
                if time < visitedW[nx][ny]-1 or visitedW[nx][ny] == 0:
                    visited[nx][ny] = time + 1
                    q.append([nx,ny,time+1])
        
# for i in visited:
#     print(i)
    
if visited[D[0]][D[1]] == 0:
    print('KAKTUS')
else:
    print(visited[D[0]][D[1]])