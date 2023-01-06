n,k = map(int,input().split())
arr = []
for i in range(n):
    arr.append(int(input()))
# <<<<<입력
arr.sort(reverse=True)
answer = 0
for i in arr:
    if k%i != k:
        answer += k // i
        k -= (k // i) * i
    else:
        pass
print(answer)
    