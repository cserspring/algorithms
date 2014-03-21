/**
 * @brief Merge two sorted array, array a is big enough 
 * to hold elements from b.
 */
#include <stdio.h>

/* a contains m elements
 * b contains n elements
 */
void sort(int *a, int *b, int m, int n)
{
    int sum = m + n - 1;
    int i = m - 1;
    int j = n - 1;
    while (i >= 0 && j >= 0) {
        if (a[i] > b[j])
            a[sum--] = b[j--];
        else
            a[sum--] = a[i--];
    }

    while (j >= 0) {
        a[sum--] = b[j--];
    }
}

int main()
{
    int a[7] = {9, 8, 4, 1};
    int b[3] = {6, 5, 2};
    sort(a, b, 4, 3);
    int i;
    for (i = 0; i < 7; ++i)
        printf("%d\n", a[i]);
    return 0;
}
