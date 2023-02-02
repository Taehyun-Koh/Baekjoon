import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

target = 1

for chu in arr:
    if target < chu:
        break

    target += chu

print(target)
            
# https://seongonion.tistory.com/127
