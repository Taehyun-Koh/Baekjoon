import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
def dfs(k):
    next = dict[k]
    global tmp
    global flag
    if next in tmp:
        tmp = tmp[tmp.index(next):]
        flag = True
        return
    if visited[next] == False:
        visited[next] = True
        tmp.append(next)
        dfs(next)

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

answer = one
for i in range(len(result)):
    answer += result[i]

myset = set(answer)
answer = list(myset)
answer.sort()

# print(answer)
print(len(answer))

for i in range(len(answer)):
    print(answer[i] + 1)


# 풀이 x 6시간

