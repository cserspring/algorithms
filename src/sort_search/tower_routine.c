/**
 * @brief LCS problem.
 */
#include <stdio.h>
#include <stdlib.h>

/*
void qsort (void* base, size_t num, size_t size,
            int (*compar)(const void*,const void*));
*/
typedef struct person {
    int height;
    int weight;
    int id;
} person_t;

int *LCS(int *a, int *b, int m, int n)
{
    int **path = (int **)malloc((m+1)*sizeof(int *));
    int i, j;
    for (i = 0; i < m+1; ++i) 
        path[i] = (int *)malloc((n+1)*sizeof(int));
    for (i = 0; i < m+1; ++i)
        path[i][0] = 0;
    for (i = 0; i < n+1; ++i)
        path[0][i] = 0;
    for (i = 1; i < m+1; ++i) {
        for (j = 1; j < n+1; ++j) {
            if (a[i-1] == b[j-1])
                path[i][j] = path[i-1][j-1] + 1;
            else if (path[i][j-1] >= path[i-1][j])
                path[i][j] = path[i][j-1];
            else
                path[i][j] = path[i-1][j];
        }
    }
    // Test
    printf("Max: %d\n", path[m][n]);
    for (i = 0; i < m+1; ++i) {
        for (j = 0; j < n+1; ++j) {
            printf("%d\t", path[i][j]);
        }
        printf("\n");
    }

    int count = path[m][n] + 1;
    int *result = (int *)malloc(count*sizeof(int));
    result[0] = path[m][n];
    i = m;
    j = n;
    while (i > 0 && j > 0) {
        if (path[i][j] == (path[i-1][j-1] + 1) && a[i-1] == b[j-1]) {
            result[--count] = a[i-1];
            --i;
            --j;
        } else if (path[i][j] == path[i][j-1]) {
            --j;
        } else {
            --i;
        }
    }
    return result;
}

int cmpheight(const void *p1, const void *p2)
{
    int h1 = ((person_t *)p1)->height;
    int h2 = ((person_t *)p2)->height;
    int w1 = ((person_t *)p1)->weight;
    int w2 = ((person_t *)p2)->weight;

    if (h1 > h2)
        return 1;
    if (h1 < h2)
        return -1;
    return 0;
}

int cmpweight(const void *p1, const void *p2)
{
    int h1 = ((person_t *)p1)->height;
    int h2 = ((person_t *)p2)->height;
    int w1 = ((person_t *)p1)->weight;
    int w2 = ((person_t *)p2)->weight;

    if (w1 > w2)
        return 1;
    if (w1 < w2)
        return -1;
    return 0;
}

int main()
{
    person_t persons[] = {{180, 65, 0}, {170, 55, 1}, {165, 63, 2}, 
                          {185, 76, 3}, {190, 80, 4}, {172, 70, 5}, 
                          {175, 68, 6}};
    int N = sizeof(persons)/sizeof(persons[0]);

    qsort(persons, N, sizeof(person_t), cmpheight);
    int *arr1 = (int *)malloc(N*sizeof(person_t));
    int *arr2 = (int *)malloc(N*sizeof(person_t));
    int i;
    // Test
    for (i = 0; i < N; ++i) {
        arr1[i] = persons[i].id; printf("%d\t", arr1[i]);}
    printf("\n");
    qsort(persons, N, sizeof(person_t), cmpweight);
    for (i = 0; i < N; ++i) {
        arr2[i] = persons[i].id; printf("%d\t", arr2[i]);}
    printf("\n");
    
    int *result = LCS(arr1, arr2, N, N);
    for (i = 1; i <= result[0]; ++i)
        printf("(%d, %d)\n", 
               persons[result[i]].height, 
               persons[result[i]].weight);
    return 0;
}
