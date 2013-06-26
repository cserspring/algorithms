#include <math.h>
#include <stdio.h>

/**
 * @brief Get the superset of the array.
 */
void print_superset(int *a, int alen)
{
    int i;
    int j = 0;
    int max = (int)pow((double)2, (double)alen);
    printf("max: %d\n", max);
    for (i = 0; i < max; i++) {
        while (j < alen) {
            if ((i >> j) & 1)
                printf("%d\t", a[j]);
            j++;
        }
        printf("\n");
        j = 0;
    }
}

int main()
{
    int a[3] = {1, 2, 3};
    print_superset(a, 3);
    return 0;
}
