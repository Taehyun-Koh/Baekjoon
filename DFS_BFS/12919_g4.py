import sys
S = input()
T = input()

def op1(s):
    s = s[:-1]
    return s
def op2(s):
    s = s[1:][::-1]
    
    return s
cnt = 0
ans = 0
def dfs(s):
    
    if s == S:
        print(1)
        sys.exit(0)
    if len(s) == 0:
        return 0
    if s[-1]=='A':
        dfs(s[:-1])
    if s[0] == 'B':
        dfs(s[1:][::-1])

dfs(T)
print(0)

    