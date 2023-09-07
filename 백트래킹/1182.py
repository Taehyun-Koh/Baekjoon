import sys
input = sys.stdin.readline

n,s = map(int,input().split())

arr = list(map(int,input().split()))

visited = [0] *n
ans = 0

def dfs(index,tmp):

    global ans
    if sum(tmp) == s:
        ans += 1
    for i in range(index+1,n):
        tmp.append(arr[i])
        dfs(i,tmp)
        tmp.pop()


for i in range(n):
    dfs(i,[arr[i]])
print(ans)
        