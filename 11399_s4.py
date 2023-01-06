n = int(input())
arr = list(map(int,input().split()))
arr.sort(reverse=True)

answer = 0
for idx,val in enumerate(arr):
    answer += val*(idx+1)

print(answer)
    

