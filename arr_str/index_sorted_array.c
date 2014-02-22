/* 输出数组在排完序之后的index排列，如1,3,2,5,4,输出为0,2,1,4,3 */
#include <stdio.h>
#include <stdlib.h>

#define N 5
int arr[N] = {1,3,2,5,4};

int cmp(const void *a, const void *b)
{
    int i = *(int *)a;
    int j = *(int *)b;
    return arr[i] - arr[j];
}

int main()
{
    int index[N] = {0,1,2,3,4};
    qsort(index, N, sizeof(int), cmp);
    int i;
    for (i = 0; i < N; ++i)
        printf("%d\t", index[i]);
    printf("\n");
    for (i = 0; i < N; ++i) 
        printf("%d\t", arr[index[i]]);
    return 0;
}
