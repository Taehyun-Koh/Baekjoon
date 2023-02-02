import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = list(map(int,input().split()))

tab = []

result = 0
for i in range(len(arr)):
        
    if len(tab) < n :
        if arr[i] in tab:
            continue
        else :
            tab.append(arr[i])
    else:
        if arr[i] in tab :
            continue
        remain = []
        
        for j in range(len(tab)):
            if tab[j] in arr[i+1:]:
                remain.append(arr[i+1:].index(tab[j]))
            else:
                remain.append(999)
        print(arr[i]," 들어올 차례 ",tab,remain)
        vic_idx = remain.index(max(remain))
        tab[vic_idx] = arr[i]
        result += 1
    
my_set = set(arr)
if n >= len(list(my_set)):
    result = 0
print(tab)
print(result)