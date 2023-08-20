import sys
input = sys.stdin.readline

N,M = map(int,input().split())
arr = list(map(int,input().split()))

arr.sort()

def binarySearch(left, right):
    
    if left > right:
        return right
    
    mid = (left + right) // 2

    total = 0
    for i in range(len(arr)):
        if arr[i] - mid > 0:
            total += arr[i] - mid

    # 톱날을 더 올려도됨
    if total > M:
        return binarySearch(mid+1, right)
    # 톱날 낮춰야함
    elif total < M:
        return binarySearch(left, mid-1)
    
    else:
        return mid
        
print(binarySearch(0,arr[-1]))