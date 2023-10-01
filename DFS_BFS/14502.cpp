#include <iostream>
#include <vector>
#include <string.h>
#include <queue>
using namespace std;

int maps[8][8];
int dx[4] = {0,0,-1,1};
int dy[4] = {-1,1,0,0};
int n,m;
int answer = 0;
vector<string> wallAvail;
vector<bool> wallVisited;
vector<vector<string>> ans;

int bfs(vector<pair<int,int>> sloc, int arr[8][8],int zerocnt){

    int count = 0;
    int visited[8][8];
    memset(visited,false,sizeof(visited));

    queue<pair<int,int>> q;
    for (auto x : sloc){
        q.push(make_pair(x.first,x.second));
        visited[x.first][x.second] = true;   
    }


    while (!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<n && 0<=ny && ny<m){
                if (!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 0){
                        count++;
                        q.push(make_pair(nx,ny));
                        arr[nx][ny]= 2;
                    }
                }
            }

        }
    }
    // cout << zerocnt - count << '\n';
    return zerocnt - count;
}

void dfs(int cnt, int index, vector<string> arr){
    if (cnt == 3){
        // for (auto x : arr){
        //     cout << x << ' ';
        // }
        // cout << '\n';
        ans.push_back(arr);
        

        return;
    }

    for (int i = index; i<wallAvail.size(); i++){
        if (!wallVisited[i]){
            wallVisited[i] = true;
            arr.push_back(wallAvail[i]);
            dfs(cnt+1, i+1, arr);
            arr.pop_back();
            wallVisited[i] = false;
        }

    }


}
int main(void){
    cin >> n >> m;

    memset(maps,0,sizeof(maps));
    for (int i = 0; i<n; i++){
        for (int j = 0; j<m; j++){
            int num; cin>>num;
            maps[i][j] = num;
            if (num == 0){
                string tmp;
                tmp = to_string(i) + to_string(j);
                wallAvail.push_back(tmp);
                wallVisited.push_back(false);
            }
        }
    }
    vector<string> tmp;
    // wallVisited[0] = true;
    dfs(0,0,tmp);
    // for (auto x : wallAvail){
    //     cout << x << ' ';
    // }
    // cout << '\n';

    for (auto x : ans){
        int temparr[8][8];

        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                temparr[i][j] = maps[i][j];
            }
        }
        for (int i = 0; i<3; i++){
            temparr[x[i][0]-'0'][x[i][1]-'0'] = 1;
        }

        int zerocnt = 0;
        vector<pair<int,int>> twoloc;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                if (temparr[i][j] == 0){

                    zerocnt++;
                }
                else if (temparr[i][j] == 2){
                    twoloc.push_back(make_pair(i,j));
                }
            }
        }
        answer = max(bfs(twoloc,temparr,zerocnt),answer);
        // for (int i = 0; i<n; i++){
        //     for (int j = 0; j<m; j++){
        //         cout << temparr[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }

        
    }

    cout << answer;

    return 0;
}