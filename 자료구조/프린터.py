from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque(priorities)
    indexq = deque([i for i in range(len(priorities))])
    flag = True
    print(indexq)
    while flag:
        first = q.popleft()
        firstIndex = indexq.popleft()
        print(first, firstIndex)
        flag = False
        for i in range(len(q)):
            if first < priorities[i] :
                q.append(first)
                indexq.append(firstIndex)
                break
        else:
            q.appendleft(first)
            indexq.appendleft(firstIndex)
            flag = False
    
    answer = indexq.index(location)
    return answer

print(solution([2,1,3,2],2))
print(solution([1,1,9,1,1,1],0))