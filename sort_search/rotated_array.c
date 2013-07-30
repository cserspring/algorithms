/**
 * @brief find an element in an rotated array.
 */

#include <stdio.h>
#define N 8

int get_index(int *a, int l, int r, int target)
{
    int m;
    while (l <= r) {
        m = (l + r)/2;
        if (a[m] == target) {
            return m;
        } else if (a[l] <= a[m]) {
            if (target > a[m])
                l = m + 1;
            else if (target >= a[l])
                r = m - 1;
            else
                l = m + 1;
        } else if (target < a[m]) {
            r = m - 1;
        } else if (target <= a[r]) {
            l = m + 1;
        } else {
            r = m - 1;
        }
    }
    return -1;
}

int main()
{
    int a[N] = {7, 8, 9, 1, 2, 3, 4, 6};
    printf("%d\n", get_index(a, 0, N - 1, 3));
    return 0;
}
