/**
 * @brief Roate the N*N matrix 90 degrees.
 */
#include <stdio.h>
#include <stdlib.h>

void rotate_90(int **matrix, int N)
{
    int **matrixcpy = (int **)malloc(sizeof(int *)*N);
    int i;
    for (i = 0; i < N; ++i)
        matrixcpy[i] = (int *)malloc(sizeof(int)*N);
    int j;
    for (i = 0; i < N; ++i) {
        for (j = 0; j < N; ++j) 
            matrixcpy[i][j] = matrix[i][j];
    }

    for (i = 0; i < N; ++i) {
        for (j = 0; j < N; ++j) {
            //left rotate 90 degrees
            //matrix[i][j] = matrixcpy[j][N - i - 1];

            //right rotate 90 degrees
            matrix[i][j] = matrixcpy[N - j - 1][i];
        }
    }
    
    for (i = 0; i < N; ++i)
        free(matrixcpy[i]);
    free(matrixcpy);
}

int main()
{
    int N;
    printf("Please input N:\n");
    scanf("%d", &N);
    printf("Please input N*N numbers to construct the matrix:\n");
    int **matrix = (int **)malloc(sizeof(int *)*N);
    int i;
    int j;
    for (i = 0; i < N; ++i)
        matrix[i] = (int *)malloc(sizeof(int *)*N);

    for (i = 0; i < N; ++i) {
        for (j = 0; j < N; ++j) 
            scanf("%d", &matrix[i][j]);
    }

    rotate_90(matrix, N);

    for (i = 0; i < N; ++i) {
        for (j = 0; j < N; ++j) 
            printf("%d\t", matrix[i][j]);
        printf("\n");
    }

    return 0;
}
