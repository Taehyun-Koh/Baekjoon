import sys
input = sys.stdin.readline

n = int(input())
vil = []
total = 0
for i in range(0,n):
    a,b = map(int , input().split(" "))
    vil.append([a,b])
    total += b

vil.sort(key=lambda x: x[0])
check = 0
for i in range(len(vil)):
    check += vil[i][1]
    if check >= total/2:
        print(vil[i][0])
        break

            

    # 1 2 3 4 5 6 7            5
    # 5 4 0 0 3 2 6
    
# 풀이 o 1시간
    
    