#include <stdio.h>
#include <stdlib.h>

int *merge(int *a, int alen, int *b, int blen)
{
    int i = 0;
    int j = 0;
    int k = 0;
    int new_len = alen + blen;
    int *result = (int *)malloc(new_len*sizeof(int));
    while (i < alen || j < blen) {
        result[k++] = a[i] < b[j] ? a[i++] : b[j++];
    }
    return result;
}

int main()
{
    int i;
    int a[5] = {3, 5, 8, 12, 19};
    int b[4] = {1, 10, 34, 89};
    int *result = merge(a, 5, b, 4);
    for (i = 0; i < 9; i++)
        printf("%d\n", result[i]);
    return 0;
}
