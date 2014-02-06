#define N 9

int checkarr(int *arr)
{
    int i;
    for (i = 0; i < N; ++i) {
        if (!arr[i])
            return 0;
    }
    return 1;
}

int is_valid(int **sudoku)
{
    int i;
    int j;
    int m;
    int n;
    int arr[N] = {0};
    for (i = 0; i < N; ++i) {
        for (j = 0; j < N; ++j) {
            arr[sudoku[i][j] - 1] = 1;
        }
        if (!checkarr(arr))
            return 0;
        memset(arr, 0, N*sizeof(int));
    }

    for (i = 0; i < N; ++i) {
        for (j = 0; j < N; ++j) {
            arr[sudoku[j][i] - 1] = 1;
        }
        if (!checkarr(arr))
            return 0;
        memset(arr, 0, N*sizeof(int));
    }

    for (i = 0; i < N; i = i+3) {
        for (j = 0; j < N; j = j+3) {
            for (m = i; m < i+3; ++m) {
                for (n = j; n < j+3; ++n) {
                    arr[sudoku[m][n] - 1] = 1;
                }
            }
            if (!checkarr(arr))
                return 0;
            memset(arr, 0, N*sizeof(int));
        }
    }
    return 1;
}
