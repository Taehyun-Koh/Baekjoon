import sys
from collections import deque
input = sys.stdin.readline


n,m = map(int,input().split())
ans = ''

weight = [0 for _ in range(n+1)]
graph = [[] for i in range(n+1)]



for i in range(1,m+1):
    a,b = map(int,input().split())
    graph[a].append(b)
    weight[b] += 1
    
    
q = deque()

for i in range(1,n+1):
    if weight[i] == 0:
        q.append(i)


while(q):
    
    student = q.popleft()
    tmp = graph[student]
    ans += str(student) + ' '
    for i in range(len(tmp)):
        weight[tmp[i]] -= 1
        if weight[tmp[i]] == 0:
            q.append(tmp[i])
            
print(ans)