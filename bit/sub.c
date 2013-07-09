#include <stdio.h>

int sub(int m, int n, int i, int j)
{
    return ((m >> (j+1)) << (j+1)) | (m & (1 << i - 1)) | (n << i);
}

int main()
{
    int m, n, i, j;
    scanf("%d%d%d%d", &m, &n, &i, &j);
    printf("%d\n", sub(m, n, i, j));
    return 0;
}
