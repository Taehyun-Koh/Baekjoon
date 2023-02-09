from sys import stdin
import sys
sero, garo = map(int, stdin.readline().split())
a = [list(map(int, stdin.readline().rstrip())) for j in range(sero)]
b = [list(map(int, stdin.readline().rstrip())) for j in range(sero)]

def flip(arr,i,j):
    for k in range(3):
        for l in range(3):
            if arr[i+k][j+l] == 0:
                arr[i+k][j+l] = 1
            else :
                arr[i+k][j+l] = 0
    return arr
    
    
result  = 0
for i in range(sero-2):
    for j in range(garo-2):
        if a[i][j] != b[i][j]:
            a = flip(a,i,j)
            result += 1
        if a == b:
            break
    if a == b:
        break

if a!=b:
    print(-1)
else:
    print(result)
    # for l in range(len(a)):
    #     print(a[l])
# print(result)

## 풀이 x 30분
    
    
