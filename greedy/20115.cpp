#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(void){
    int n; cin >> n;
    vector<int> arr;
    for (int i = 0; i<n; i++){
        int tmp; cin >>tmp;
        arr.push_back(tmp);
    }

    sort(arr.begin(),arr.end(),greater<>());
    float ans = 0;
    while (arr.size() > 1){
        float quan = float(arr.back());
        ans += quan/2;
        arr.pop_back();
    }
    cout << ans + float(arr[0]);
    return 0;
}