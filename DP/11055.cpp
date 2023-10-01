#include <iostream>
#include <algorithm>

using namespace std;

int N;
int arr[1001];
int dp[1001];

int main(){
    cin >> N;
    int ans = 0;
    for (int i = 1; i<=N; i++){
        cin >> arr[i];
    }
    for (int i = 1; i<=N; i++){
        for (int j = 1; j<i; j++){
            if (arr[j] < arr[i]){
                dp[i] = max(dp[i],dp[j]);
            }
        }
        dp[i] += arr[i];
        ans = max(dp[i],ans);
    }
    cout << ans;
    return 0;
}