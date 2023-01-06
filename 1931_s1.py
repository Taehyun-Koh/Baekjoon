n = int(input())
arr = []
for i in range(n):
    m = list(map(int,input().split()))
    arr.append(m)

arr.sort(key=lambda x:x[1]-x[0])

ans_arr = []
for i in arr:
    avail = True
    # print("ans_arr = ",ans_arr)
    for j in ans_arr:
        if (i[0] <=j[0] and i[1] <=j[0]) or (i[0] >= j[1] and i[1] >= j[1]):
            # print(i,"가능 여부 :",j,"통과")
            pass
        else:
            # print(i,"가능 여부 :",j,"와 겹침\n")
            avail = False
            break
    if avail == True:
        ans_arr.append(i)
        # print(i,"추가\n")
ans_arr.sort(key=lambda x:x[0])
print(ans_arr)
print(len(ans_arr))