#include <iostream>
#include <vector>
#include <set>
using namespace std;

set<int> ans;
vector<int> arr;
vector<bool> visited;

int n,k;

void back(int cnt, int index, vector<int> tmp){
    if (cnt == k){
        string s;
        for (auto i : tmp){
            // cout << i << ' ';
            s += to_string(arr[i]);
        }
        // cout << ' '<< s << '\n';
        ans.insert(stoi(s));

        return;
    }

    for (int i = 0; i<n; i++){
        if (!visited[i]){
            visited[i] = true;
            tmp.push_back(i);
            back(cnt+1, i, tmp);
            tmp.pop_back();
            visited[i] = false;
        }

    }
}

int main(void){
    
    
    
    cin >> n;
    cin >> k;

    for (int i = 0; i<n; i++){
        int num;
        cin >> num;
        arr.push_back(num);
        visited.push_back(false);
    }
    vector<int> tmp;
    back(0,0,tmp);
    // ans 벡터에 저장된 결과 출력
    cout << ans.size();
    return 0;
}