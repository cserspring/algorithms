/**
 * @brief Swap the odd/even bits.
 */
#include <stdio.h>

int swap(int value)
{
    int odd = value & 0xAAAAAAAA;
    int even = value & 0x55555555;
    return (((odd >> 1) & 0x7FFFFFFF) | (even << 1));
}

int main()
{
    int value;
    scanf("%d", &value);
    printf("New value: %d\n", swap(value));
    return 0;
}
