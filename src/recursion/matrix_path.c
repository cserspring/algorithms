/*
 * @brief Use a bottom-to-top approach to get the paths from start to end 
 *        in a matrix.
 * @author: Shuai Wang (shuai@cmu.edu)
 */

#include <stdio.h>

#define M 5
#define N 3

typedef struct coordinate {
    int x;
    int y;
} coordinate_t;

/*
 * Bottom-to-top approach
 */
void path(int m, int n, coordinate_t *stack, int *top)
{
    int i;
    coordinate_t c;
    c.x = m;
    c.y = n;
    stack[(*top)++] = c;
    if (m == 0 && n == 0) {
        for (i = (*top-1); i >= 0; --i) 
            printf("[%d, %d]\t", stack[i].x, stack[i].y);
        printf("\n");
    }
    // move up
    if (m > 0)
        path(m - 1, n, stack, top);
    // move left
    if (n > 0)
        path(m, n - 1, stack, top);
    --(*top);
}

int main()
{
    /* To store the elements from start (0,0) to end (4,2) */
    coordinate_t stack[M+N-1];
    /* Point to the top of the stack */
    int top = 0;
    path(M-1, N-1, stack, &top);
}

