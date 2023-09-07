import sys
import heapq
input = sys.stdin.readline

n = int(input())
m = int(input())


graph = [[] for _ in range(n+1)]
visited = [1000000000] * (n+1)

for i in range(m):
    s,e,c = map(int,input().split())
    graph[s].append([e,c])


s,e = map(int,input().split())

def dijkstra(s):
    pq = []
    heapq.heappush(pq,[s,0])
    
    visited[s] = 0
    
    while pq:
        curr, cost = heapq.heappop(pq)
        
        ## 최단거리가 아닌경우 스킵
        if visited[curr] < cost:
            continue
        
        for next,nextcost in graph[curr]:
            total = nextcost + cost
            if visited[next] > total:
                visited[next] = total
                heapq.heappush(pq,[next,total])
    
dijkstra(s)
print(visited[e]) 
        
    