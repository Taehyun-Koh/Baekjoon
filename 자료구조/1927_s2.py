import heapq
import sys
input = sys.stdin.readline

n = int(input())
heap = []

for _ in range(n):
    num = int(input().strip())
    if num == 0:
        try:
            a = heapq.heappop(heap)
        except IndexError:
            print(0)
        else:
            print(a)
    else:
        heapq.heappush(heap,num)
            