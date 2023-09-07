
import sys
input = sys.stdin.readline

H,W,X,Y = map(int,input().split())

arr = []
A = [ [0]* W for _ in range(H)]

for _ in range(H+X):
    arr.append(list(map(int,input().split())))
    
for i in range(H):
    for j in range(W):
        A[i][j] = arr[i][j]

for i in range(X,H):
    for j in range(Y,W):
        A[i][j] = arr[i][j] - A[i-X][j-Y]

for i in range(H):
    for j in range(W):
        print(A[i][j], end=" ")
    print()