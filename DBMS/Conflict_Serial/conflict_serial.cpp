#include <bits/stdc++.h>

using namespace std;
const int total_transaction = 100;

//  R1(A) , R2(A) , R1(B) , R2(B) , R3(B) , W1(A) , W2(B)

vector<pair<pair<char, int>, string>> transaction, a;
set<int> Node[total_transaction];
set<int> all_transaction;

int vis[total_transaction] = {0};
int parent = 0;
bool flag = true;

/*
    0 - not visited  (white)
    1 - visiting ... (grey)
    2 - completed    (black)
*/

void dfs(int x)
{
    if (vis[x] == 1)
    {
        flag = false;
        cout << "\nCycle found\n";
        cout << parent << " -- " << x << " ";
        return;
    }
    if (vis[x] == 2)
    {
        return;
    }

    vis[x] = 1;
    parent = x;

    for (int child : Node[x])
    {
        dfs(child);
    }

    vis[x] = 2;
    return;
}

int main()
{

    fstream new_file;
    int N = 0;

    new_file.open("in.txt", ios::in);

    if (new_file.is_open())
    {
        string s;
        string delimiter = "(";
        string delimiter2 = ")";
        size_t posOpen = 0, posClose = 0;
        string serial, variable;
        char mode;
        const char * sa;
        
        while (getline(new_file, s))
        {
            pair<pair<char, int>, string> operation;    //  R1(A)

            mode = s[0];

            posOpen = s.find(delimiter);
            serial = s.substr(1, posOpen-1);

            s.erase(0, posOpen + delimiter.length());
            posClose = s.find(delimiter2);
            variable = s.substr(0, posClose);
            sa = serial.data();

            operation.first.first = mode;                     //  R
            operation.first.second = atoi(sa);                //  1
            operation.second = variable;                         //  (A)
            transaction.push_back(operation);
        }
        new_file.close();
    }
    
    else
        cout << "FIle not found\n";

    for (int i = 0; i < transaction.size(); i++)
    {
        char current_operator_type = transaction[i].first.first;    // R or W
        int current_transaction_no = transaction[i].first.second;   // 1,2,3,....
        string current_variable = transaction[i].second;            // (variable)

        all_transaction.insert(current_transaction_no);
        for (int j = i + 1; j < transaction.size(); j++)
        {
            char next_operator_type = transaction[j].first.first;
            int next_transaction_no = transaction[j].first.second;
            string next_variable = transaction[j].second;

            if (tolower(current_operator_type) == 'w' or (tolower(current_operator_type) == 'r' and tolower(next_operator_type) == 'w'))
            {
                if (current_variable == next_variable and current_transaction_no != next_transaction_no)
                {
                    Node[current_transaction_no].insert(next_transaction_no);
                }
            }
        }
    }

    for (int tr : all_transaction)
    {
        dfs(tr);
    }

    if (flag)
        cout << "\n\nConflict serializable\n";
    else
        cout << "\n\nNot conflict serializable\n";
}