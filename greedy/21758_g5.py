import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split(" ")))
total = sum(arr)
answer = 0
case = []

# case1 bee bee home
tmp = arr[0]
for i in range(1,n):
    tmp += arr[i]
    answer = max(answer, total - arr[0] + total - tmp - arr[i])

# case2 bee home bee
m = max(arr[1:len(arr)])
answer = max(answer,sum(arr[1:len(arr)-1]) + m)

# case3 home bee bee

arr.reverse()
tmp = arr[0]
for i in range(1,n):
    tmp += arr[i]
    answer = max(answer, total - arr[0] + total - tmp - arr[i])

print(answer)

## 풀이 x 2시간