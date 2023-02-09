import sys
input = sys.stdin.readline

n = int(input())
tmp = list(map(int, input().split(" ")))

arr = tmp[::-1]

print(arr)