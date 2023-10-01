#include <iostream>
#include <stack>

using namespace std;

int main(void){
    int num; cin >> num;
    stack<int> st;
    for (int i =0; i<num; i++){
        string cmd; cin >> cmd;
        
        if (cmd == "push"){
            int n; cin>>n;
            st.push(n);
            continue;
        }
        else if(cmd == "top"){
            if (st.empty()) {
                cout << -1 << '\n';
                continue;
            }
            cout << st.top() << '\n';
        }
        else if(cmd == "size"){
            cout << st.size() << '\n';
        }
        else if(cmd == "empty"){
            if (st.empty()){
                cout << 1 << '\n';
            } else{
                cout << 0 << '\n';
            }
        }
        else if (cmd == "pop"){
            if (st.empty()){
                cout << -1 << '\n';
                continue;
            }
            cout << st.top() << '\n';
            st.pop();
        }

    }
    return 0;
}