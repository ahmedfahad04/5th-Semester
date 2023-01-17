#include <bits/stdc++.h>
#include <vector>
#include <string>
#include <sstream>
#include <iostream>
using namespace std;

vector<string> string_split(string input_str, char delimeter)
{
    vector<string> result;
    stringstream s_stream(input_str); // create string stream from the string

    while (s_stream.good())
    {
        string substr;
        getline(s_stream, substr, delimeter); // get first string delimited by comma
        result.push_back(substr);
    }

    return result;
}

int main()
{

    fstream newfile;
    vector<string> row, headline;
    vector<vector<string>> allRows;
    vector<pair<string, vector<string>>> column_wise_data;
    string line;
    int line_cnt = 0;

    // READ THE FILE LINE BY LINE
    newfile.open("ballons.csv", ios::in);
    if (newfile.is_open())
    {
        row.clear();
        line_cnt += 1;

        // read an entire row and
        // store it in a string variable 'line'
        while (getline(newfile, line))
        {

            // read every column data of a row and
            // store it in a string variable, 'word'
            row = string_split(line, ',');

            if (line_cnt == 1)
            {
                headline = row;
            }
            else
                allRows.push_back(row);

            line_cnt += 1;
        }

        newfile.close();
    }

    // STORE COLUMN WISE DATA
    for (int col_no = 0; col_no < allRows[col_no].size(); col_no++)
    {

        vector<string> eachColumnData;
        for (int row_no = 0; row_no < allRows.size(); row_no++)
        {
            eachColumnData.push_back(allRows[row_no][col_no]);
        }

        column_wise_data.push_back({headline[col_no], eachColumnData});
    }

    // PRINT COLUMN WISE DATA
    for(int i=0; i<column_wise_data.size(); i++) {
        
        string colHead = column_wise_data[i].first;

        cout << "COL_HEAD: " << colHead << endl;

        vector<string> colData = column_wise_data[i].second;
        
        for(int j=0; j<column_wise_data[i].second.size(); j++) {
            cout << colData[j] << " ";
        }

        cout << endl;
    }


}