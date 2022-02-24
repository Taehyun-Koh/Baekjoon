total_num = int(input())

for i in range(total_num):
    cnt = 0
    score = list(map(int,input().split()))
    std = score[0]
    avg = (sum(score) - std)/std
    for j in score:
        if j==0:
            continue
        elif j>avg:
            cnt+=1
    print(f"{cnt/std*100:.3f}"+"%")
