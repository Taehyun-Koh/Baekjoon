#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> arr;
int main(void){

    long long res = 0;

    cin >> n;
    for (int i = 0; i<n; i++){
        int num;
        cin >> num;
        arr.push_back(num);
    }

    sort(arr.begin(), arr.end(), greater<>());

    for (int i =0; i<n; i++){
        int tmp = arr[i] - i;
        if (tmp >= 0){
            res += tmp;
        }
    }
    cout << res;
    return 0;
}