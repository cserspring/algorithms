/**
 * @brief Fibonacci
 */
#include <stdio.h>

/* Time is O(2^n) */
int fib_recursive(int n)
{
    if (n == 0)
        return 0;
    if (n == 1) 
        return 1; 
    return (fib_recursive(n - 1) + fib_recursive(n - 2));
}

int fib_iterate(int n)
{
    int result = 0;
    int a = 0;
    int b = 1;
    if (n == 0)
        return a;
    if (n == 1)
        return b;
    int i;
    int tmp;
    for (i = 1; i < n; ++i) {
        tmp = b;
        b = a + b;
        a = tmp;
    }
    return b;
}

int fib(int term, int val, int prev)
{
    if(term == 0) 
        return prev;
    if(term == 1) 
        return val;
    return fib(term - 1, val+prev, val);
}

int main()
{
    int n;
    scanf("%d", &n);
    printf("%d\n", fib_recursive(n));
    printf("%d\n", fib_iterate(n));
    printf("%d\n", fib(n, 1, 0));
    return 0;
}
