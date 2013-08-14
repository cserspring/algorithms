#include <iostream>
#include <cstring>
using namespace std;

char* LCS(const char* x, const char* y);

int main()
{
    char* x = "cbfgade";
    char* y = "bcagfde";

    char* s = LCS(x, y);
    cout<<"最长公共子序列为："<<s<<endl;
    cout<<"长度为："<<strlen(s)<<endl;
    return 0;
}

char* LCS(const char* x, const char* y)
{
    int m = strlen(x);
    int n = strlen(y);

    int** c = new int*[m + 1];
    for (int i = 0; i < m + 1; i++) {
        c[i] = new int[n + 1];
        //每一行第一个元素初始化为0
        c[i][0] = 0;
    }

    //第一行初始化为0
    for (int i = 0; i < n + 1; i++)
        c[0][i] = 0;

    for (int i = 1; i < m + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
            if (x[i - 1] == y[j - 1])
                c[i][j] = c[i - 1][j - 1] + 1;
            else if (c[i][j - 1] >= c[i - 1][j])
                c[i][j] = c[i][j - 1];
            else
                c[i][j] = c[i - 1][j];
        }
    }

    //c[m][n]值为最短子序列的长度
    //用result来保存逆序LCS，通过c[m][n]的值与c[m - 1][ n - 1]，c[m][n - 1]，c[m - 1][n]来判断
    int len = c[m][n];
    char* result = new char[len + 1];
    int count = len;
    while (m > 0 && n > 0) {
        if (c[m][n] == c[m - 1][ n - 1] + 1 && x[m - 1] == y[n - 1]) {
            result[--count] = x[m - 1];
            m--;
            n--;
        } else if (c[m][n] == c[m][n - 1]) {
            n--;
        } else {
            m--;
        }
    }
    result[len] = '\0';

    //释放内存
    for (int i = 0; i < m + 1; i++)
        delete[] c[i];
    delete []c;

    return result;
}
