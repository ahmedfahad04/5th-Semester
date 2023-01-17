#include <bits/stdc++.h>
using namespace std;

int main() {
    string s = "r122225(hello)";

    string delimiter = "(";
    string delimiter2 = ")";
    size_t posOpen = 0, posClose = 0;

    string var1, variable;
    char mode;

    mode = s[0];

    posOpen = s.find(delimiter);
    var1 = s.substr(1, posOpen-1);

    s.erase(0, posOpen + delimiter.length());
    posClose = s.find(delimiter2);
    variable = s.substr(0, posClose);

    const char * ctr = var1.data();
    cout <<  mode << "\n" << atoi(ctr)+1 << "\n" << variable << endl;
}