import sys
input = sys.stdin.readline

P,M = map(int,input().split())

firstl, firstn = input().split()
firstl = int(firstl)
room = [[firstl,[[firstl,firstn]]]]

for p in range(1,P):
    l, n = input().split()
    l = int(l)
    for r in range(len(room)):
        if abs(room[r][0] - l) <= 10:
            if len(room[r][1]) <=M-1:
                room[r][1].append([l,n])
                break
    else:
        room.append([l,[[l,n]]])

for i in range(len(room)):
    arr = room[i][1]
    arr.sort(key=lambda x: x[1])
    
    if len(arr) == M :
        print("Started!")
    else:
        print("Waiting!")
    
    for j in range(len(arr)):
        print(arr[j][0], arr[j][1])