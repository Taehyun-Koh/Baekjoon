import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline
v,e = map(int,input().split())

graph = []
parent = [0] * (v+1)
for i in range(1, v+1):
    parent[i] = i
    
for i in range(e):
    s,e,cost = map(int,input().split())
    graph.append([cost,s,e])

graph.sort()

def find(x):
    if parent[x] == x:
        return x
    return find(parent[x])

def union(x,y):
    x = find(x)
    y = find(y)
    
    if x!=y:
        if x < y:
            parent[y] = x
        else:
            parent[x] = y
        return True
    else:
        return False
    

ans = 0
cnt = 0
for x in graph:
    if cnt == v+1 :break
    
    if union(x[1],x[2]) == True :
        ans += x[0]
        cnt += 1
    else:
        continue

print(ans)
        
    

    