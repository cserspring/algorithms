#include <stdio.h>

#define BITS 32

int diff (int a, int b)
{
    int i;
    int c = a^b;
    int count = 0;
    int tmp;
    for (i = 0; i < BITS; ++i) {
        tmp = 1 << i;
        if ((c & tmp) == tmp)
            ++count;
    }
    return count;
}

int main()
{
    int a, b;
    scanf("%d%d", &a, &b);
    printf("%d\n", diff(a, b));
    return 0;
}
