## sort 사용 시간초과풀이
import sys
input = sys.stdin.readline

cards = []
results = 0

n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

if n == 1:
    print(0)
    
else:
    while len(arr) > 1:
        arr.sort()
        plus = arr[0] + arr[1]
        results += plus
        
        del arr[0]
        del arr[0]
        arr.append(plus)

    print(results)
    