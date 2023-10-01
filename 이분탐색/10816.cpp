#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n,m;
vector<int> arr;

int upperbound(int n, int lo, int hi){
    
    while (lo < hi){
        int mid = (lo + hi) / 2;

        if (arr[mid] <= n){
            lo = mid + 1;
        } else{
            hi = mid;
        }
    }
    return lo;
}

int lowerbound(int n, int lo, int hi){
    while (lo < hi){
        int mid = (lo + hi) / 2;

        if (arr[mid] < n){
            lo = mid + 1;
        } else{
            hi = mid;
        }
    }
    return lo;
}

int main(){

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for (int i = 0; i<n; i++){
        int tmp; cin >> tmp;
        arr.push_back(tmp);
    }
    sort(arr.begin(), arr.end());
    cin >> m;
    for (int i = 0; i<m; i++){
        int num; cin >> num;
        cout << upperbound(num, 0, arr.size()) - lowerbound(num, 0, arr.size()) << ' ';
    }
    return 0;
}