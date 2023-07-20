import sys
input = sys.stdin.readline

N = int(input())
arr = []
for n in range(N):
    arr.append(list(map(int, input().split())))

ans = []
for a in arr:
    tmp = 1
    for b in arr:
        if a==b:
            continue
        if a[0] < b[0] and a[1] < b[1]:
            tmp += 1
    
    ans.append(tmp)
print(*ans)