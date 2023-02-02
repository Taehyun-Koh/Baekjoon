import sys
input = sys.stdin.readline
import heapq

cards = []
results = 0

n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

heapq.heapify(arr)

if n == 1:
    print(0)
    
else:
    while len(arr) > 1:
        plus = heapq.heappop(arr) + heapq.heappop(arr)
        results += plus
        heapq.heappush(arr,plus)
    print(results)