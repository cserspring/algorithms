/**
 * To get the longest increasing subsequence of an array.
 * 
 * First solution: 
 *   sort the array to get the sorted array, 
 *   then get LCS(sorted_arr, original_arr);
 *
 * Second solution:
 *   to make every element as the tail, then get the elements that less than and 
 *   before it.
 */
#include <cstdio>
#include <cstdlib>
#include <vector>
using namespace std;

static int cmp(const void *p1, const void *p2);
static int *LCS(int *arr1, int *arr2, int len, int *res_len);

int *solution1(int *arr, int len, int *res_len)
{
    int i;
    int *arr_copy = (int *)malloc(len * sizeof(int));
    for (i = 0; i < len; ++i)
        arr_copy[i] = arr[i];
    qsort(arr_copy, len, sizeof(int), cmp);
    return LCS(arr_copy, arr, len, res_len);
}

vector<int> solution2(int *arr, int len)
{
    vector<vector<int> > vec;
    vector<int> tmp;
    for (int i = 0; i < len; ++i) {
        tmp.clear();
        for (int j = 0; j < i; ++j) {
            if (arr[j] < arr[i])
                tmp.push_back(arr[j]);
        }
        tmp.push_back(arr[i]);
        vec.push_back(tmp);
    }
    int index = 0;
    int longest = vec[0].size();
    for (int i = 1; i < vec.size(); ++i) {
        if (vec[i].size() > longest) {
            longest = vec[i].size();
            index = i;
        }
    }
    return vec[index];
}

static int cmp(const void *p1, const void *p2)
{
    int q1 = *(int *)p1;
    int q2 = *(int *)p2;
    return q1 - q2;
}

static int *LCS(int *arr1, int *arr2, int len, int *res_len)
{
    int i, j;
    int **c = (int **)malloc(sizeof(int *)*(len + 1));
    for (i = 0; i < len+1; ++i) {
        c[i] = (int *)malloc((len + 1)*sizeof(int));
    }
    
    for (i = 0; i < len + 1; ++i)
        c[i][0] = 0;
    for (i = 0; i < len + 1; ++i)
        c[0][i] = 0;
    
    for (i = 1; i < len + 1; ++i) {
        for (j = 1; j < len + 1; ++j) {
            if (arr1[i-1] == arr2[j-1])
                c[i][j] = c[i-1][j-1] + 1;
            else
                c[i][j] = (c[i-1][j] > c[i][j-1]) ? c[i-1][j] : c[i][j-1];
        }
    }
    
    int *result = (int *)malloc(sizeof(int)*c[len][len]);
    int x = len;
    int y = len;
    *res_len = c[len][len];
    int count = c[len][len];
    while (x > 0 && y > 0) {
        if (c[x][y] == c[x-1][y-1] + 1 && arr1[x-1] == arr2[y-1]) {
            result[--count] = arr1[x-1];
            x--;
            y--;
        } else if (c[x][y] == c[x][y-1]) {
            y--;
        } else {
            x--;
        }
    }  
    return result;      
}

int main()
{
    int arr[5] = {10,20,30,21,22};
    int len;
    int *result = solution1(arr, 5, &len);
    int i;
    for (i = 0; i < len; i++)
        printf("%d\n", result[i]);

    printf("***********\n");
    /* Solution 2*/
    vector<int> r = solution2(arr, 5);
    for (int i = 0; i < r.size(); ++i)
        printf("%d\n", r[i]);
    return 0;
}
