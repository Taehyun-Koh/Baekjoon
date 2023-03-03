import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
def dfs(k):
    target = dict[k]
    global tmp
    global flag
    if tmp[0] == target:
        flag = True
        return
    if visited[target] == False:
        visited[target] = True
        tmp.append(target)
        dfs(target)

n = int(input())
dict = {}

for i in range(n):
    a = int(input()) - 1
    dict[i] = a

visited = [False] * n
result = []
one = []
for i in range(n):
    if i == dict[i]:
        visited[i] = True
        one.append(i)
    
    if visited[i] == False:
        tmp = []
        flag = False
        tmp.append(i)
        visited[i] = True
        dfs(i)
        # print(tmp,flag)
        
        if flag == True:
            result.append(tmp)

max_len = 0
answer = one
for i in range(len(result)):
    answer += result[i]

answer.sort()
# print(answer)

print(len(answer))

for i in range(len(answer)):
    print(answer[i] + 1)
