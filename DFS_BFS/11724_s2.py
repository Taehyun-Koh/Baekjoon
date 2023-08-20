import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)


# 풀이 o

def dfs(v):
    visited[v] = True
    ## graph[v] = [2,5]
    for i in graph[v]:
        if visited[i] == False:
            visited[i] = True
            dfs(i)

n,m = map(int,input().split())
graph = [[]  for _ in range(n+1)]
visited = [False] * (n+1)

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = 0
for i in range(1,n+1):
    if visited[i] == False:
        cnt += 1
        dfs(i)
print(cnt)