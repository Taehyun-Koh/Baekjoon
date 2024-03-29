#include <iostream>
#include <vector>
using namespace std;

int T = 0;
vector<int> dp;

int main(void){

    cin >> T;

    dp.resize(12,0);
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i<11; i++){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    for (int t = 0; t<T; t++){
        int n;
        cin >> n;
        cout << dp[n] << '\n';
    }
    return 0;
}