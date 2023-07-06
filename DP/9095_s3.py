import sys
input = sys.stdin.readline

def dfs(num):
    if arr[num] > 0:
        return arr[num]
    if num == 1:
        return 1
    elif num == 2:
        return 2
    elif num == 3:
        return 4
    else:
        arr[num] = dfs(num-1) + dfs(num-2) + dfs(num-3)
        return arr[num]

n = int(input())

for _ in range(n):
    tmp = int(input())
    arr = [0] * (tmp + 1)
    print(dfs(tmp))
    
    
