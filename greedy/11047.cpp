#include <iostream>
#include <vector>
using namespace std;

int main(){

    int n, price;
    cin >> n >> price;

    vector<int> arr;
    for (int i =0; i<n ;i++){
        int tmp; cin >> tmp;
        arr.push_back(tmp);
    }
    
    int ans = 0;
    for (int i = n-1; i>=0; i--){
        while (price - arr[i] >= 0){
            price -= arr[i];
            ans += 1;
        }
    }
    cout << ans;
    return 0;
}