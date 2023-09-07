import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))

lis = [0]

for x in arr:
    
    if lis[-1] < x:
        lis.append(x)
    else:
        lo = 0
        hi = len(lis)
        
        while lo < hi:
            mid = (lo + hi) // 2
            
            if x <= lis[mid] :
                hi = mid
            else:
                lo = mid + 1
        lis[lo] = x

print(len(lis)-1)