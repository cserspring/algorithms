/**
 * @brief To let the anagrams are next to each other.
 */

#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;

#define N 7

int cmp(string s1, string s2)
{
    sort(&s1[0], &s1[0] + s1.length());
    sort(&s2[0], &s2[0] + s2.length());
    return s1 < s2;
}

int main()
{
    string str[N] = {"abc", "bac", "hw", "wh", "cg", "gc", "za"};
    sort(str, str + N, cmp);
    for (int i = 0; i < N; ++i)
        cout << str[i] << endl;
    return 0;
}
