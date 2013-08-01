/**
 * @brief A matrix, row and column are sorted.
 */
#include <stdio.h>

#define M 3
#define N 4

void find(int matrix[M][N], int target)
{
    int i = 0;
    int j = N - 1;
    while (i < M && j >= 0) {
        if (matrix[i][j] == target) {
            printf("(%d, %d)\n", i, j);
            return;
        } else if (matrix[i][j] > target) {
            --j;
        } else {
            ++i;
        }
    }
    printf("None\n");
}

int main()
{
    int matrix[M][N] = {1,3,5,7,2,4,6,8,10,12,14,18};
    find(matrix, 10);
    find(matrix, 3);
    find(matrix, 15);
    return 0;
}
