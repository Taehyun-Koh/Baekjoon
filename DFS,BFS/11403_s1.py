import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(x):
    for i in range(n):
        if visited[i] == 0 and graph[x][i] == 1:
            visited[i] = 1
            dfs(i)

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]

for i in range(n):
    visited = [0] * n
    dfs(i)
    print(*visited)
    
# 3시간 풀이o