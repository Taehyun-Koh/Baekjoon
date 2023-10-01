#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

map<string,int> arr;
vector<string> voca;
bool compare(string a, string b){
    if (a.size() == b.size() && arr[a] == arr[b]){
        return a<b;
    } else if (arr[a] == arr[b]){
        return a.size() > b.size();
    }
    return arr[a] > arr[b];
}
int main(void){
    int n,m;
    cin >> n >> m;

    for (int i =0; i < n; i++){
        string tmp; cin >> tmp;
        if (tmp.size() < m) continue;
        if (arr.find(tmp) == arr.end()){
            arr[tmp] = 0;
            voca.push_back(tmp);
        }
        arr[tmp] += 1;
    }
    sort(voca.begin(), voca.end(), compare);

    for (auto p : voca)
        cout << p << '\n';

    return 0;
}