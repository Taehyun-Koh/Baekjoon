a,b = map(int,input().split())

result = 1

while b > a:
    if b % 2 != 0:
        b = (b-1) / 10
        result += 1
    else:
        b = b/2
        result += 1
if b == a : print(result)
else: print(-1)

## 풀이 x 5분