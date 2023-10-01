#include <iostream>
#include <string>
#include <algorithm>

bool cmp(int &a, int &b){
    return a>b;
}
using namespace std;
int graph[26];
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n; cin >> n;
    for (int i =0; i<n; i++){
        string input; cin >> input;
        int pow = 1;
        for (int j = input.length() - 1; j>=0; j--){
            graph[input[j] - 'A'] += pow;
            pow *= 10;
        }
    }
    sort(graph, graph+26, greater<>());
    int num = 9;
    int answer = 0;
    for (int i = 0; i< 26; i++){
        if (graph[i] == 0) 
            break;
        answer += graph[i] * num;
        num--;

    }
    cout << answer;
    return 0;
}