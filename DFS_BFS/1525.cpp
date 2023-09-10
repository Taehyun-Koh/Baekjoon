#include <iostream>
#include <vector>
#include <string.h>
#include <string>
#include <queue>
#include <set>

using namespace std;

int dx[4] = {0,0,-1,1};
int dy[4] = {-1,1,0,0};

int maps[3][3];
int n = 3;
string Start,End;
set<string> visited;

int bfs(){
    queue<pair<string,int>> q;
    
    q.push(make_pair(Start, 0));
    visited.insert(Start);

    while (q.empty() == 0){
        string cur = q.front().first;
        int cnt = q.front().second;
        q.pop();

        if (cur == End) return cnt;

        int zero = cur.find('0');
        int x = zero / 3;
        int y = zero % 3;

        for (int i = 0; i< 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<3 && 0<=ny && ny<3){
                string next = cur;
                swap(next[x*3 + y], next[nx*3 + ny]);

                if (visited.count(next) == 0){
                    visited.insert(next);
                    q.push(make_pair(next,cnt+1));
                }
            }
        }
    }
    return -1;
}
int main(void){

    End = "123456780";   
    for (int i = 0; i<n; i++){
        for (int j = 0; j<n; j++){
            int num; cin>> num;
            string Tmp = to_string(num);
            Start = Start + Tmp;
        }
    }
    
    cout << bfs();
    return 0;
}