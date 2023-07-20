import sys
input = sys.stdin.readline

T = int(input())
for t in range(T):
    N = int(input())
    ans = 0
    while N//5 > 0 :
        ans += N//5
        N /= 5
    print(int(ans))

        