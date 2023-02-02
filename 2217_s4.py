import sys
input = sys.stdin.readline

n = int(input())
rope = []
for _ in range(n):
    rope.append(int(input()))

rope.sort(reverse=True)
mx = []
for i in range(len(rope)):
    tmp = rope[i] * (i+1)
    if len(mx) != 0:
        if mx[-1] > tmp:
            continue
    mx.append(tmp)
# print(mx)
print(mx[-1])
    