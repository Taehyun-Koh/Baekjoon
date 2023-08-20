import sys
input = sys.stdin.readline

L,C = map(int,input().split())


tmp = input().strip().split(' ')

tmp.sort()
def dfs(string,index,mo,ja):
    if len(string) == L:
        if mo >= 1 and ja >=2:
            print(string)
            return
    
    for i in range(index+1,C):
        print(string)
        if tmp[i] in "aeiou":
            dfs(string+tmp[i], i, mo+1, ja)
        else :
            dfs(string+tmp[i], i, mo, ja+1)
        
    
    
for i in range(C-L+1):
    if tmp[i] in "aeiou":
        dfs(tmp[i], i, 1, 0)
    else :
        dfs(tmp[i], i, 0, 1)
    
    
        
