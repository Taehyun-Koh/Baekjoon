import sys
input = sys.stdin.readline
##신입사원 -- 풀이참고
test_num = int(input())
arr = []
for _ in range(test_num):
    n = int(input())
    tmp = [list(map(int,input().split())) for _ in range(n)]
    tmp.sort(key = lambda x : x[0])
##############입력####################
    answer = 1
    top = 0
    for i in range(1, len(tmp)):
        if tmp[i][1] < tmp[top][1]:
            top = i
            answer += 1
    print(answer)
    