#include <stdio.h>
#include <stdlib.h>

void count(int row, int col, int *deno, int **table)
{
    int i;
    int j;
    for (i = 1; i < row; i++) {
        for (j = 1; j < col; j++) {
            if (i - deno[j] < 0) {
                table[i][j] = table[i][j - 1];
            } else {
                table[i][j] = table[i - deno[j]][j] + table[i][j - 1];
            }
        }
    }
}

void print(int **table, int row, int col)
{
    
}

int main()
{
    int denominations[] = {0, 2, 4, 5};
    int N = 9;
    int M = 3;
    int i;
    int j;
    //int table[N][M];
    int **table = (int **)malloc(sizeof(int *)*(N+1));
    for (i = 0; i < N + 1; i++) {
        table[i] = (int *)malloc(sizeof(int)*(M+1));
    }
    
    for (i = 0; i < M + 1; i++)
        table[0][i] = 1;
    for (i = 1; i < N + 1; i++)
        table[i][0] = 0;
    count(N+1, M+1, denominations, table);
    for (i = 0; i < N + 1; i++) {
        for (j = 0; j < M + 1; j++) {
            printf("%d\t", table[i][j]);
        }
        printf("\n");
    }
    return 0;
}
