#include <iostream>
#include <vector>
using namespace std;

void combination(int n, int start, int *coin, int num, 
                 vector<int> vec, int& count)
{
    for (int i = start; i < num; ++i) {
        vector<int> tmp(vec);
        tmp.push_back(coin[i]);
        if (n > coin[i]) {
            combination(n - coin[i], i, coin, num, tmp, count);
        } else if (n == coin[i]) {
            for (int j = 0; j < tmp.size(); ++j)
                cout << tmp[j] << '\t';
            cout << endl;
            count++;
        } 
    }
}

int main()
{
    int coin[4] = {25, 10, 5, 1};
    int n;
    cin >> n;
    vector<int> vec;
    int count = 0;
    combination(n, 0, coin, 4, vec, count);
    cout << "Number of combinations: " << count << endl;
    return 0;
}
