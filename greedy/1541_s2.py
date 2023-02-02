##1541-잃어버린 괄호
n = input().split('-')
answer = 0
for i in range(0,len(n)):
    arr = n[i].split('+')
    arr = map(int,arr)
    if i==0:
        answer += sum(arr)
    else:
        answer -= sum(arr)
print(answer)