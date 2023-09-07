import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))

plus, minus, multi, divi = map(int,input().split())

arr = []
visited = [0] * (n-1)
for i in range(n-1):
    if plus > 0:
        arr.append("pl")
        plus -= 1
    elif minus > 0:
        arr.append("mi")
        minus -= 1
    elif multi > 0:
        arr.append("mul")
        multi -=1 
    elif divi > 0:
        arr.append("div")
        divi -= 1
# print(arr)
maxv = -1000000001
minv = 1000000001

def dfs(cnt,tmp):
    global maxv
    global minv
    if cnt == n-1:
        print(tmp)
        ans = nums[0]
        for i in range(len(tmp)):
            if tmp[i] == 'pl':
                ans += nums[i+1]
            elif tmp[i] == 'mi':
                ans -= nums[i+1]
            elif tmp[i] == 'mul':
                ans *= nums[i+1]
            elif tmp[i] == 'div':
                if ans < 0:
                    ans = -(abs(ans) // nums[i+1])
                else:
                    ans //= nums[i+1]
        maxv = max(maxv, ans)
        minv = min(minv, ans)

        return
    
    for i in range(n-1):
        if visited[i] == 0:
            tmp.append(arr[i])
            # print("before = " ,tmp)
            visited[i] = 1
            dfs(cnt+1, tmp)
            del tmp[len(tmp)-1]
            # print("after dfs = ",tmp)
            visited[i] = 0

dfs(0,[])
print(maxv,minv)
