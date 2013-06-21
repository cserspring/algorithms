#include<stdio.h>

int add(int x, int y)
{
    if (y == 0)
        return x;
    else
        return add(x ^ y, (x & y) << 1);
}
int main()
{
    int x = 607;
    int y = 201;
    printf("%d\n", add(x,y));
    return 0;
}
