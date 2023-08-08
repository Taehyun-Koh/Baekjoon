import sys
input = sys.stdin.readline

n = int(input())
ans = 0
arr = [0] * n


def nQueen(depth):
    global ans
    if n == depth:
        ans+=1
        return
    
    for i in range(n):
        arr[depth] = i
        
        if Possibility(depth):
            nQueen(depth+1)
            
            
def Possibility(col):
    for i in range(col):
        
        if arr[col] == arr[i]:
            return False
        
        elif abs(col - i) == abs(arr[col] - arr[i]):
            return False
        
    return True
       
nQueen(0)
print(ans) 