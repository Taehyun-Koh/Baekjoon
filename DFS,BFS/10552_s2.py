import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

n,channel,begin = map(int,input().split())
curr = begin

lst = []
hate = {}
for i in range(n):
    a,b = map(int,input().split())
    
    if hate.get(b) == None:
        hate[b] = [a]
    else :
        arr = hate.get(b)
        arr.append(a)
        hate[b] = arr
cnt = 0
tmp = 0
while True:
    if tmp > n:
        cnt = -1
        break
    if hate.get(curr) != None:
        curr = hate.get(curr)[0]
        tmp += 1
        cnt += 1
    else:
        break

print(cnt)
    
## 풀이 x 30분