#include <stdio.h>
#include <stdlib.h>

#define LEN 10

void part_sort(int *a, int p, int q, int r)
{
    int i, j;
    int *left = (int *)malloc((q-p+1)*sizeof(int));
    int *right = (int *)malloc((r-q)*sizeof(int));
    for(i = 0; i < q-p+1; i++)
        left[i] = a[p + i];
    for(i = 0; i < r - q; i++)
        right[i] = a[q + i +1];
    
    int m = 0;
    int n = 0;
    i = p;
    while (m < q-p+1 && n < r-q)
        a[i++] = left[m] > right[n] ? right[n++] : left[m++];
    while (m < q-p+1)
        a[i++] = left[m++];
    while (n < r-q)
        a[i++] = right[n++];
    free(left);
    free(right);
}

void mergesort(int *a, int m, int n)
{
    if(m < n) {
        int mid = (m + n)/2;
        mergesort(a, m, mid);
        mergesort(a, mid+1, n);
        part_sort(a, m, mid, n);
    }
}

int main()
{
    int i;
    int arr[LEN] = {4, 3, 2, 7, 1, 9, 2, 5, 7, 6};
    mergesort(arr, 0, LEN-1);
    for (i = 0; i < LEN; ++i)
        printf("%d\n", arr[i]);
    return 0;
}
