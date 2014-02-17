/*
 You are given a grid of numbers. A snake sequence is made up of adjacent 
 numbers such that for each number, the number on the right or the number 
 below it is +1 or -1 its value. For example, 

 1  3 2  6 8 
 -9 7 1 -1 2 
 1  5 0  1 9 

 In this grid, (3, 2, 1, 0, 1) is a snake sequence. 

 Given a grid, find the longest snake sequences and their length
 */

//dp solution
//in matrix_lis, as dp just step one step back, it does not step two steps back
//so it is wrong.
//in matrix_snake, it just go right or below, so this algorithm is right.
#include <stdio.h>
#include <math.h>

#define M 3
#define N 5

int matrix[M][N] = 
{
1,3,2,6,8,
-9,7,1,-1,2,
1,5,0,1,2
};

int dp[M][N];
int get_max()
{
    int i, j;
    for (i = 0; i < M; ++i) {
        for (j = 0; j < N; ++j) {
            dp[i][j] = 1;
        }
    }

    for (i = 0; i < M; ++i) {
        for (j = 0; j < N; ++j) {
            if ((j+1 < N) && abs(matrix[i][j+1]-matrix[i][j]) == 1){
                dp[i][j+1] = (dp[i][j+1] > (dp[i][j]+1)) ? dp[i][j+1] : (dp[i][j]+1);
            }
            if ((i+1 < M) && abs(matrix[i+1][j]-matrix[i][j]) == 1) {
                dp[i+1][j] = (dp[i+1][j] > (dp[i][j]+1)) ? dp[i+1][j] : (dp[i][j]+1);
            }
        }
    }

    int max = 0;
    for (i = 0; i < M; ++i) {
        for (j = 0; j < N; ++j) {
            printf("%d\t", dp[i][j]);
            if (dp[i][j] > max)
                max = dp[i][j];
        }
        printf("\n");
    }
    return max;
}

int main()
{
    printf("%d\n", get_max());
}
