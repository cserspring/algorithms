#include <stdio.h>

#define m 10
#define n 10

//int original[m][n] = {1, 2, 3, 4};

int original[m][n] = 
{
97,47,56,36,60,31,57,54,12,55,
35,57,41,13,82,80,71,93,31,62,
89,36,98,75,91,46,95,53,37,99,
25,45,26,17,15,82,80,73,96,17,
75,22,63,96,96,36,64,31,99,86,
12,80,42,74,54,14,93,17,14,55,
14,15,20,71,34,50,22,60,32,41,
90,69,44,52,54,73,20,12,55,52,
39,33,25,31,76,45,44,84,90,52,
94,35,55,24,41,63,87,93,79,24
};

int longest[m][n] = {0};

int findfor(int i, int j);

int find() {
    int max = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int current = findfor(i, j);
            if (current > max) {
                max = current;
            }
        }
    }
    return max;
}
//static int count = 0;

int findfor(int i, int j) {
    int max = 0;
    if (longest[i][j] == 0) {
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if (!(k == 0 && l == 0) &&
                    i + k >= 0 && i + k < m &&
                    j + l >= 0 && j + l < n &&
                    original[i + k][j + l] > original[i][j]
                    ) {
                    int current = findfor(i + k, j + l);
                    if (current > max) {
                        max = current;
                    }
                }
            }
        }
        longest[i][j] = max + 1;
    }
    return longest[i][j];
}    

int main()
{
    printf("%d\n", find());
    return 0;
}
