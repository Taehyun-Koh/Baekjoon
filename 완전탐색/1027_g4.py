import sys
input = sys.stdin.readline

def slope(x1,y1,x2,y2):
    return (y2-y1)/(x2-x1)

N = int(input())
arr = list(map(int,input().split()))
answer = 0
view = []
for idx, val in enumerate(arr):
    view_max = 0
    left_max = float('inf') # 왼쪽의 기울기 최솟값
    right_max = -float("inf") # 오른쪽 기울기 최댓값
    for i in range(idx-1,-1,-1):  # 왼쪽
        c = slope(idx+1,val,i+1,arr[i]) 
        if c < left_max: # 기울기가 더 작다면
            left_max = c 
            view_max += 1
    for i in range(idx+1,N):  # 오른쪽
        c = slope(idx+1,val,i+1,arr[i])
        if c > right_max: # 기울기가 더 크다면
            right_max = c
            view_max += 1
    view.append(view_max)
print(max(view))