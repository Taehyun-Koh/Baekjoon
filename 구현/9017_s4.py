T = int(input())
ans = []
for t in range(T):
    n = int(input())
    arr = list(map(int, input().split()))
    team_dict = {}
    for i in range(len(arr)):
        if arr[i] not in team_dict:
            team_dict[arr[i]] = [i]
        else:
            team_dict[arr[i]].append(i)
    for i in range(1, len(team_dict) + 1):
        if len(team_dict[i]) < 6:
            del team_dict[i]
        else:
            team_dict[i] = [sum(team_dict[i][0:4]), team_dict[i][4]]

    answer = 0
    maxv = [0, 0]

    for key, val in team_dict.items():
        if val[0] > maxv[0]:
            maxv = val
            answer = key
        elif val[0] == maxv[0]:
            if maxv[1] > val[1]:
                answer = key
                maxv = val
    ans.append(answer)

for i in range(T):
    print(ans[i])
