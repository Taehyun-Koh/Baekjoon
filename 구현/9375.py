import sys
from itertools import combinations
input = sys.stdin.readline

T = int(input())

for t in range(T):
    dic = {}
    n = int(input())
    for _ in range(n):
        a,b = map(str,input().split())
        try:
            dic[b] += 1
        except KeyError:
            dic[b] = 1
    arr = []
    for key,val in dic.items():
        arr.append(val)
    


    tmp = 1
    for i in range(len(arr)):
        tmp *= arr[i] + 1
    print(tmp-1)
