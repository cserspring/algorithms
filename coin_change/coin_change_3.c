#include <stdio.h>

// a makes it in order
void coin_change(int *coin, int n, int amount, int *count, int a)
{
    int i;
    for (i = 0; i < n; ++i) {
        if (coin[i] >= a) {
            if (amount == coin[i]) {
                (*count)++;
                break;
            } else if (amount < coin[i]) {
                break;
            } else {
                coin_change(coin, n, amount - coin[i], count, coin[i]);
            }
        }
    }
}

int main()
{
    int coin[3] = {1,2,3};
    int amount = 10;
    int count = 0;
    coin_change(coin, 3, amount, &count, 0);
    printf("%d\n", count);
}
