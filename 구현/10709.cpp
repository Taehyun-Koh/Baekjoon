#include <iostream>
#include <string.h>

using namespace std;
int main(void){
    int h;
    int w; // h 행, w 열
    cin >> h >> w;
    int maps[h][w];
    memset(maps,-1,sizeof(maps));
    int minv = 101;
    for (int i = 0; i<h; i++){
        string s;
        cin >> s;

        for (int j = 0; j <w; j++){
            if (s[j] == 'c'){
                maps[i][j] = 0;
                minv = min(minv, j);
            }
        }
    }


    for (int i = minv; i<w-1; i++){
        for (int j = 0; j<h; j++){
            if (maps[j][i] != -1){
                if (maps[j][i+1] != 0){
                    maps[j][i+1] = maps[j][i] + 1;
                }
                
            }
        }
    }
    
    for (int i = 0; i<h; i++){
        for (int j = 0; j <w; j++){
            cout <<  maps[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}