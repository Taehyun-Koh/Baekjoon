import sys
input = sys.stdin.readline


n = int(input())

alpha = []
for _ in range(n):
    alpha.append(input().replace("\n", ""))

d={}
for word in alpha: #단어를 읽으며 각 알파벳의 자릿수와 나타나는 빈도를 수치화시켜준다.
    digit=len(word)
    for alphabet in word:
        if alphabet not in d: #해당 알파벳이 기존 dictionary에 없던 거일때는 key를 추가해야함
            d[alphabet]=10**(digit-1)
        else: #해당 알파벳이 기존 dicitionary에 있던 거일때는 값을 더해야함
            d[alphabet]+=10**(digit-1)
        digit-=1
            

d = dict(sorted(d.items(), key=lambda x: x[1],reverse=True))
# print(d)
result = 0

tmp = 9
for idx,val in d.items():
    d[idx] = tmp
    tmp-=1

# print(d)
for i in alpha:
    for idx,one in enumerate(i):
        # print(idx, len(i), int(d[one]*(math.pow(10,len(i)-idx-1))))
        if idx == len(i) - 1:
            result += d[one]
        else:
            result += int(d[one]*(10**(len(i)-idx-1)))

    

if n == 0:
    result = 0
    
print(result)
