import sys
input = sys.stdin.readline
# n = int(input())
# arr = []
# for i in range(n):
#     m = list(map(int,input().split()))
#     arr.append(m)

# arr.sort(key=lambda x:x[1]-x[0])
# # print("짧은 회의시간 기준 정렬 = ",arr)
# ans_arr = []
# for i in arr:
#     avail = True
#     # print("ans_arr = ",ans_arr)
#     for j in ans_arr:
#         ## 추가하고자 하는 회의가 배정돼있는 회의시간과 겹치는지 확인
#         if (i[0] <=j[0] and i[1] <=j[0]) or (i[0] >= j[1] and i[1] >= j[1]):
#             # print(i,"가능 여부 :",j,"통과")
#             pass
#         else:
#             # print(i,"가능 여부 :",j,"와 겹침\n")
#             avail = False
#             break
#     if avail == True:
#         ans_arr.append(i)
#         # print(i,"추가\n-----------------------------")
# ans_arr.sort(key=lambda x:x[0])
# # print("최종 배정 = ",ans_arr)
# print(len(ans_arr))


n = int(input())
s = []
for i in range(n):
    first, second = map(int, input().split())
    s.append([first, second])
s = sorted(s, key=lambda a: a[0])
# print(s)
s = sorted(s, key=lambda a: a[1])
# print(s)
last = 0
cnt = 0
for i, j in s:
    if i >= last:
        cnt += 1
        last = j
print(cnt)