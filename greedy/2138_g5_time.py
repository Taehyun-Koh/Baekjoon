# import sys
# import copy
# input = sys.stdin.readline

# n = int(input())
# curr = list(map(int,input().strip()))
# goal = list(map(int,input().strip()))

# def flip(n):
#     if n == 0:
#         return 1
#     if n== 1:
#         return 0
    
# result_first = 0
# clickarr = copy.deepcopy(curr)

# for i in range(n):
#     if clickarr == goal:
#         break
#     if i == 0:
#         clickarr[i] = flip(clickarr[i])
#         clickarr[i+1] = flip(clickarr[i+1])
#         result_first += 1
#     if clickarr[i-1] != goal[i-1] :
#         if i == n-1:
#             clickarr[i-1] = flip(clickarr[i-1])
#             clickarr[i] = flip(clickarr[i])
#             result_first += 1
#         else:
#             clickarr[i-1] = flip(clickarr[i-1])
#             clickarr[i] = flip(clickarr[i])
#             clickarr[i+1] = flip(clickarr[i+1])
#             result_first += 1

# if clickarr != goal:
#     result_first = -1
    
    
# result = 0
# nclick = copy.deepcopy(curr)
# for i in range(n):
#     if nclick == goal:
#         break
#     if i == 0:
#         continue
#     if nclick[i-1] != goal[i-1] :
#         if i == n-1:
#             nclick[i-1] = flip(nclick[i-1])
#             nclick[i] = flip(nclick[i])
#             result += 1
#         else:
#             nclick[i-1] = flip(nclick[i-1])
#             nclick[i] = flip(nclick[i])
#             nclick[i+1] = flip(nclick[i+1])
#             result += 1

    
# if nclick != goal:
#     result = -1

# if result == -1 and result_first == -1:
#     print(-1)
# elif result == -1 or result_first == -1:
#     print(max(result,result_first))
# else:
#     print(min(result,result_first))
    
    
n = int(input())
c = list(map(int,input().rstrip("\n")))
want = list(map(int,input().rstrip("\n")))

def change(num):
    if num == 0:
        num = 1
    else:
        num = 0
    return num

def switch(c, cnt):
    count = cnt
    if count == 1:
        c[0] = change(c[0])
        c[1] = change(c[1])
    for i in range(1, n):
        if c[i-1] != want[i-1]:
            count += 1
            c[i-1] = change(c[i-1])
            c[i] = change(c[i])
            if i != n-1:
                c[i+1] = change(c[i+1])
    if c == want:
        return count
    else:
        return -1

res1 = switch(c[:], 0)
res2 = switch(c[:], 1)
if res1 >= 0 and res2 >= 0:
    print(min(res1, res2))
elif res1>=0 and res2 < 0:
    print(res1)
elif res1 <0 and res2 >= 0:
    print(res2)
else:
    print(-1)
    
## 풀이참조 2시간