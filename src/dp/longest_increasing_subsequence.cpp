/**
 * To get the longest increasing subsequence of an array.
 * 
 * First solution: 
 *   sort the array to get the sorted array, 
 *   then get LCS(sorted_arr, original_arr);
 *
 * Second solution:
 *   L(i) = { 1 + MAX(L(j)) }, i>j && arr[i]>arr[j]
 */
#include <cstdio>
#include <cstdlib>
#include <stack>
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

stack<int> solution2(int *arr, int len)
{
	int *lis = (int *)malloc(sizeof(int) * len);
	for (int i = 0; i < len; ++i) {
		lis[i] = 1;
	}
	for (int i = 1; i < len; ++i) {
		for (int j = 0; j < i; ++j) {
			if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
				lis[i] = lis[j] + 1;
		}
	}

	int res_len = lis[0];
	int index = 0;
	for (int i = 1; i < len; ++i) {
		if (lis[i] > res_len) {
			res_len = lis[i];
			index = i;
		}
	}

	stack<int> v;
	int cur = arr[index];
	v.push(cur);
	for (int i = index - 1; i >= 0; --i) {
		if (arr[i] < cur) {
			cur = arr[i];
			v.push(cur);
		}
	}
	return v;
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
    stack<int> r = solution2(arr, 5);
    while (!r.empty()) {
        printf("%d\n", r.top());
        r.pop();
	}
    return 0;
}
