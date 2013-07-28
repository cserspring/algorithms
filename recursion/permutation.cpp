/**
 * @brief Permutation of string.
 */

#include <iostream>
#include <string>
#include <vector>
using namespace std;

/* Insert the first character to the remaining string */
vector<string> permutation(string str)
{
    vector<string> result;

    if (str.size() == 1) {
        result.push_back(str);
        return result;
    }

    string c(1, str[0]);
    string s(str);
    s.erase(0, 1);
    
    vector<string> tmp = permutation(s);
    for (int k = 0; k < tmp.size(); ++k) {
        int size = tmp[k].size();
        for (int j = 0; j <= size; ++j) {
            string tmpstr(tmp[k]);
            result.push_back(tmpstr.insert(j, c));
        }
    }
    return result;
}

int main()
{
    string str;
    cin >> str;
    vector<string> v = permutation(str);
    cout << v.size() << endl;
    for (int i = 0; i < v.size(); ++i) {
        cout << v[i] << endl;
    }
    return 0;
}
