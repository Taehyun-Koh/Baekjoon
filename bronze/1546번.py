n = int(input())

score = list(map(int,input().split()))
max = max(score)
fake = list(map(lambda x:x/max*100,score))

print(round(sum(fake)/n,10))