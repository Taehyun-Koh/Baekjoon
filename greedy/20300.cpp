#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;

int main(void){

    int n;
    
    cin >> n;
    vector<long> arr;

    for (int i = 0; i < n; i++){
        long num;
        cin >> num;
        arr.push_back(num);

    }

    sort(arr.begin(), arr.end());

    long maxv = 0;
    if (n % 2==0){
        for (int i =0; i<n/2; i++){
            maxv = max(maxv, arr[i] + arr[n-i-1]);
        }
    }
    else{
        maxv = arr.back();
        // arr.pop_back();
        for (int i =0; i<n/2; i++){
            maxv = max(maxv, arr[i] + arr[n-i-2]);
        }
    }
    cout << maxv;
    return 0;
}