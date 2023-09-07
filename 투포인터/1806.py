import sys
input = sys.stdin.readline

n,s = map(int,input().split())

arr = list(map(int,input().split()))

a = 0
b = 0

ans = n+1
sum =0
while True:
    if sum >= s:
        ans = min(ans, b-a)
        sum -= arr[a]
        a += 1
    elif b == n:
        break
    else:
        sum += arr[b]
        b += 1

if ans == n+1:
    print(0)
else:
    print(ans)