#include <iostream>
#include <queue>
#include <string.h>

using namespace std;
bool ok = false;
int dy[4] = { -1,1,0,0 };
int dx[4] = { 0,0,-1,1 };
char graph[304][304];
int n, m, kingx, kingy, goalx, goaly;

void bfs(int x, int y){
    bool visited[n][m];
    memset(visited, false, sizeof(visited));

    queue<pair<int,int>> q;
    q.push({x,y});
    visited[x][y] = 1;

    while (!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (graph[nx][ny] == '#'){
                ok = true;
                return;
            }
            if (0<=nx && nx<n && 0<=ny && ny<m){
                if (visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    if (graph[nx][ny] == '1') graph[nx][ny] = '0';
                    else if (graph[nx][ny] == '0') q.push({nx,ny});
                }
            }
        }
    }
}
int main(void){
    cin >> n >> m;
    cin >> kingx >> kingy >> goalx >> goaly;
    kingx -= 1;
    kingy -= 1;
    goalx -= 1;
    goaly -= 1;

    for (int i = 0; i<n; i++){
        for (int j = 0; j<m; j++){
            cin >> graph[i][j];
        }
    }
    int res = 0;
    
    while (1){
        res += 1;
        bfs(kingx,kingy);
        if (ok) break;
    }
    cout << res;
    return 0;
}