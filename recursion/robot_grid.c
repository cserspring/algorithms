/**
 * @brief A robot moves in N*N grid
 */

#include <stdio.h>
#include <vector>
#include <utility>
using namespace std;

void move(int i, int j, int n, vector<pair<int, int> > v)
{
    v.push_back(make_pair(i, j));
    if (i < n - 1) {
        move(i+1, j, n, v);
    }
    if (j < n - 1) {
        move(i, j+1, n, v);
    }
    if (i == n - 1 && j == n - 1) {
        for (int i = 0; i < v.size(); ++i)
            printf("(%d, %d)\t", v[i].first, v[i].second);
        printf("\n");
    }
}

int main()
{
    int n;
    scanf("%d", &n);
    vector<pair<int, int> > v;
    move(0, 0, n, v);
    return 0;
}
