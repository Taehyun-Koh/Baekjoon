import sys
# dfs 탐색
def dfs(v):
    # 한줄씩 비교
    for i in range(n):
        if check[i] == 0 and graph[v][i] == 1:
            check[i] = 1
            dfs(i)


n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

for x in range(n):
    # 체크 리스트를 초기화하여 수행
    check = [0 for _ in range(n)]
    dfs(x)
    print(*check) # 리스트의 경우에는 *기호를 넣어서 각각의 값을 출력할 수 있다.
    
# 3시간 풀이o