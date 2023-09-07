import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
arr.sort()

m = int(input())
ans = list(map(int,input().split()))
for i in range(m):
    num = ans[i]
    
    lo = 0
    hi = n
    while lo < hi:
        mid = (lo + hi) // 2
        
        if num < arr[mid] :
            hi = mid
        elif num > arr[mid]:
            lo = mid + 1
        else:
            print(1)
            break
    else:
        print(0)
            