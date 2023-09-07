import sys
input = sys.stdin.readline

def init():
    for i in range(n):
        tree[S+i] = 0
    for i in range(S-1,-1,-1):
        tree[i] = tree[i*2] + tree[i*2 + 1]

def query(left, right, node, ql, qr):
    if qr < left or right < ql:
        return 0
    elif ql <= left and right <= qr:
        return tree[node]
    else:
        mid = (left + right) // 2
        return query(left, mid, node*2, ql, qr) + query(mid+1, right, node*2 + 1, ql, qr)

def update(left, right, node, target, diff):
    if target <left or target > right:
        return
    
    else:
        tree[node] += diff
        if left != right:
            
            mid = (left + right) // 2
            update(left ,mid ,node*2, target, diff)
            update(mid + 1, right ,node*2 + 1, target, diff)       
n = int(input())

tree = []
S = 1

while S < n:
    S *= 2
tree = [0] * (S*2)
init()

arr = list(map(int,input().split()))
tmp = list(map(int,input().split()))

dic = {}
for i in range(n):
    dic[tmp[i]] = i + 1

ans = 0
for i in range(n):
    a  =query(1,S,1,dic[arr[i]]+1,n)
    ans += a
    
    update(1,S,1,dic[arr[i]],1)
print(ans)


