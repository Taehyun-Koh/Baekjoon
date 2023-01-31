# import sys
# input = sys.stdin.readline

# n = int(input())

# chu = list(map(int,input().split()))
    
# # chu.sort(reverse=True)
# # print(chu)
# wmax = sum(chu)
# answer = 0

# for i in range(1,wmax):
#     aim = i
#     for j in range(len(chu)):
#         # print(j, aim, chu[j])
#         if aim - chu[j] > 0:
#             aim = aim - chu[j]
#         elif aim - chu[j] == 0:
#             aim = aim - chu[j]
#             break
        
#     if aim != 0:
#         answer = i
#         break

# print(answer)
            
import sys
input = sys.stdin.readline

n = int(input())

chu = list(map(int,input().split()))
    
# chu.sort(reverse=True)
# print(chu)
wmax = sum(chu)
answer = 0

for j in range(1,len(chu)):
    aim = j
    print(j, aim, chu[j])
    while aim > 0:
        if aim - chu[j] > 0:
            aim = aim - chu[j]
        elif aim - chu[j] == 0:
            aim = aim - chu[j]
            break
    print('\n')


print(answer)
            
