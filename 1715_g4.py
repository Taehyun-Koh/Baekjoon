import sys
input = sys.stdin.readline

n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))
arr.sort()
answer = 0
lst = []
for i in range(0,len(arr),2):
    if i !=len(arr)- 1:
        lst.append(arr[i] + arr[i+1])
print(lst)