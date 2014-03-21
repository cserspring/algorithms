/**
 * @brief Find the next larger and smaller integer which have the same 
 * number of bit 1
 * @bug smaller of 0x7FFFFFFF should be -2
 */

#include <stdio.h>
#define BITS 32

int next_larger(int value)
{
    int i;
    int j;
    // right most '1'
    for (i = 0; i < BITS; ++i) {
        if ((value & (1 << i)) == (1 << i)) {
            break;
        }
    }
    if (i == BITS - 1 || i == BITS)
        return 0;
    // the '0' just before '1'
    for (j = i + 1; j < BITS - 1; ++j) {
        if ((value & (1 << j)) == 0) {
            break;
        }
    }
    if (j == BITS - 1)
        return 0;

    value = value & (~(1 << i));
    return (value | (1 << j));
}

/* There is bug here */
int next_smaller(int value)
{
    int i;
    int j;
    for (i = 0; i < BITS; ++i) {
        if ((value & (1 << i)) == 0)
            break;
    }
    for (j = i + 1; j < BITS; ++j) {
        if ((value & (1 << j)) == (1 << j))
            break;
    }
    value = value & (~(1 << j));
    return (value | (1 << (j - 1)));
}

int main()
{
    int value;
    scanf("%d", &value);

    int larger = next_larger(value);
    if (larger == 0)
        printf("No larger value\n");
    else
        printf("Larger: %d\n", larger);

    int smaller = next_smaller(value);
    printf("Smaller: %d\n", smaller);
    return 0;
}
