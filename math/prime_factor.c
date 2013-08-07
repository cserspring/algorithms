#include <stdio.h>
#include <stdlib.h>

int min(int a, int b, int c)
{
    int tmp = a < b ? a : b;
    return tmp < c ? tmp : c;
}

int get_result(int n)
{
    if (n <= 0)
        return -1;
    int position = n;
    int *p = (int *)malloc(sizeof(int)*n);
    p[0] = 1;

    int index = 0;
    int *p1 = p;
    int *p2 = p;
    int *p3 = p;
    while (--n > 0) {
        int m = min(*p1*3, *p2*5, *p3*7);
        p[++index] = m;
        while (*p1*3 <= m)
            ++p1;
        while (*p2*5 <= m)
            ++p2;
        while (*p3*7 <= m)
            ++p3;
    }

    return p[position-1];
}

int main()
{
    int n;
    scanf("%d", &n);
    int c = get_result(n);
    printf("%d\n", c);
    return 0;
}
