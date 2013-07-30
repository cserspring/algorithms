/**
 * N queue problem
 */
#include <stdio.h>
#include <stdlib.h>

#define N 8
int row[N];

void print()
{
    static int count = 0;
    int i;
    printf("%dth:\t", ++count);
    for (i = 0; i < N; ++i)
        printf("%d\t", row[i]);
    printf("\n");
}

int check(int j)
{
    int i;
    for (i = 0; i < j; ++i) {
        if (row[i] == row[j] || abs(row[i] - row[j]) == abs(i - j))
            return 0;
    }
    return 1;
}

int place(int r)
{
    if (r == N) {
        print();
        return;
    }
    int i;
    for (i = 0; i < N; ++i) {
        row[r] = i;
        if (check(r))
            place(r + 1);
    }
}

int main()
{
    place(0);
    return 0;
}
