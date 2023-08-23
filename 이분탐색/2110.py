import sys
input = sys.stdin.readline
N,C = map(int,input().split())

def cntWifi(distance):
    
    lastloc = arr[0]
    cnt = 1
    
    for i in range(1,N):
        currloc = arr[i]
        
        if currloc - lastloc >= distance:
            lastloc = currloc
            cnt += 1
        
    return cnt

arr = []
for _ in range(N):
    arr.append(int(input()))

arr.sort()

lo = 1
hi = arr[-1] - arr[0] + 1

while lo < hi:
    mid = (lo + hi) // 2
    # 현재 거리를 뒀을 때 더 설치할 수 있음 => 간격줄이기
    if cntWifi(mid) < C:
        hi = mid
    # 현재 거리가 너무 가까워서 설치개수를 줄여야함 => 간격늘리기
    else:
        lo = mid + 1

print(lo-1)
    


            