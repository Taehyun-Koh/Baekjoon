#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string a, string b){
    if (a.size() == b.size()) return a<b;
    return a.size()<b.size();
}
int main(void){
    int n; cin >> n;
    vector<string> ans;

    for (int i = 0; i<n; i++){
        string s; cin >> s;
        string tmp;

        int index = -1;
        int size = s.size();
        for (int j = 0; j<size; j++){
            char curr = s[j];
            // 숫자면
            if (!isalpha(curr)){
                if (index == j-1){
                    tmp.push_back(curr);
                } else{
                    if (index == -1){
                        tmp.push_back(curr);
                    }else{
                        ans.push_back(tmp);
                        tmp.clear();
                        tmp.push_back(curr);
                    } 
                }
                index = j;
            }
            // cout << tmp << ' ' << index << '\n';
        }
        if (tmp.size() > 0){
            ans.push_back(tmp);
        }
        

    }
    
    vector<string> answer;
    if (ans.size() > 0){
        for (int i = 0; i<ans.size(); i++){
            string s;
            bool flag = false;
            for (int j =0; j<ans[i].size(); j++){
                
                if (ans[i][j] == '0' && !flag){
                    continue;
                }
                else{
                    flag = true;
                    s.push_back(ans[i][j]);
                }

            }
            if (s.size() == 0) s = '0';
            answer.push_back(s);
        }
    }
    sort(answer.begin(), answer.end(),cmp);
    for (auto x : answer){
        cout << x << '\n';
    }

    return 0;
}