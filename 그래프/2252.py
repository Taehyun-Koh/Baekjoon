import sys
from collections import deque
input = sys.stdin.readline

v,e = map(int,input().split())


## 1. 진입차수 0인 정점 큐에 삽입
## 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거
## 3. 간선 제거 이후 진입차수 0이 된 정점을 큐에 삽입

## 2-3 반복 후 모든 정점을 방문하기 전 큐가 빈다면 사이클 존재

## 모든 노드에 대한 진입차수
indegree = [0] * (v+1)

## 각 노드에 연결된 간선정보 배열
graph = [[] for _ in range(v+1)]


for _ in range(e):
    a,b = map(int,input().split())
    graph[a].append(b) ## 간선 저장
    indegree[b] += 1 ## 진입차수 업데이트

def topology_sort():
    res = [] # 결과 배열
    q = deque()
    
    # 처음 시작할 때 진입차수 0인 노드를 큐에 삽입
    for i in range(1,v+1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()
        res.append(now)
        
        # 해당 노드와 연결된 노드들의 진입차수에서 1빼기
        for i in graph[now]:
            indegree[i] -= 1
            
            # 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
            if indegree[i] == 0:
                q.append(i)
    for i in res:
        print(i, end=' ')

topology_sort()