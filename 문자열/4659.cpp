#include <iostream>

using namespace std;


bool check1(string s){

    for (int i = 0; i<s.size(); i++){
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u'){
            return true;
        }
    }
    return false;
}

bool check2(string s){
    int ja = 0;
    int mo = 0;
    for (int i =0; i<s.size(); i++){
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u'){
            if (ja >= 3){
                return false;
            }
            else{
                ja = 0;
                mo += 1;
            }
        }
        else{
            if (mo >= 3){
                return false;
            }
            else{
                ja += 1;
                mo = 0;
            }
        }
    }
    if (mo >= 3 || ja >=3) return false;
    return true;
}

bool check3(string s){
    char w = s[0];
    for (int i =1; i<s.size(); i++){
        if (w == s[i]){
            if (s[i] == 'e' || s[i] == 'o'){
                w = s[i];
            }
            else return false;
        }
        else w = s[i];
    }
    return true;
}

int main(void){
    
    while (true) {
        string s; cin >> s;
        if (s == "end") break;

        bool flag = check1(s);
        if (flag){
            flag = check2(s);
        }
        if (flag){
            flag = check3(s);
        }


        if (flag) {
            cout << "<" << s << ">" << " is acceptable.\n";
        }
        else {
            cout << "<" << s << ">" << " is not acceptable.\n";
        }

    }
    

    return 0;
}