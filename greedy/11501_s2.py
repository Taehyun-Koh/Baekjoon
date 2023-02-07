import sys
input = sys.stdin.readline

n = int(input())
case = []

for _ in range(n):
    m = int(input())
    case.append(list(map(int,input().split())))

for i in range(len(case)):
    result = 0
    if case[i] == sorted(case[i],reverse = True): 
        print(result)
        continue
    else:
        gojum_idx = case[i].index(max(case[i]))
        
        for j in range(len(case[i])):
            if j == gojum_idx:
                try:
                    gojum_idx = case[i][j+1:].index(max(case[i][j+1:])) + j+1
                except ValueError:
                    break
            else:
                result += case[i][gojum_idx] - case[i][j]
        print(result)

## 풀이 x 40분
            
            
        