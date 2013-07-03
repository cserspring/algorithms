/**
 * @brief Hanoi Tower Problem
 */
#include <stdio.h>

/**
 * Recursive approach
 * A is source, C is destination, B is the helper.
 */
void hanoi_recursive(int N, char A, char B, char C)
{
    if (N == 1) {
        printf("Move disk %d from %c to %c\n", N, A, C);
    } else {
        hanoi_recursive(N - 1, A, C, B);
        printf("Move disk %d from %c to %c\n", N, A, C);
        hanoi_recursive(N - 1, B, A, C);
    }
}

int main()
{
    int num_of_disk;
    scanf("%d", &num_of_disk);
    hanoi_recursive(num_of_disk, 'A', 'B', 'C');
    return 0;
}
