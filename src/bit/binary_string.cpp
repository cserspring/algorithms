#include <iostream>
#include <string>
#include <cstdlib>
#include <stack>
using namespace std;

void print_binary(string str)
{
    size_t dot_pos = str.find_first_of('.');
    string int_str = str.substr(0, dot_pos);
    string dec_str = str.substr(dot_pos);
    int int_part = atoi(int_str.c_str());
    double dec_part = atof(dec_str.c_str());

    stack<int> sbit;
    while (int_part != 0) {
        sbit.push(int_part%2);
        int_part /= 2;
    }
    while (!sbit.empty()) {
        cout << sbit.top();
        sbit.pop();
    }
    cout << ".";
    if (dec_str.length() > 32) {
        cout << "ERROR" << endl;
        return;
    } else {
        while (dec_part != 0.0) {
            dec_part *= 2;
            if (dec_part == 1.0) {
                cout << 1;
                break;
            } else if (dec_part > 1.0) {
                dec_part -= 1.0;
                cout << 1;
            } else {
                cout << 0;
            }
        }
    }
    cout << endl;
}

int main()
{
    string str;
    cin >> str;
    print_binary(str);
    return 0;
}
