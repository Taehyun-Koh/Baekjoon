import sys
from itertools import combinations
input = sys.stdin.readline

n,s = map(int,input().split(" "))
arr = list(map(int,input().split(' ')))

result = 0

for i in range(1,n+1):
    combi = list(combinations(arr,i))
    for j in combi:
        if sum(j) == s:
            result += 1
    
    
print(result)

# 5분 풀이 x
