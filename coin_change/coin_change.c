#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int count( int S[], int m, int n )
{
    // table[i] will be storing the number of solutions for
    // value i. We need n+1 rows as the table is consturcted
    // in bottom up manner using the base case (n = 0)
    int table[n+1];
 
    // Initialize all table values as 0
    memset(table, 0, sizeof(table));
 
    // Base case (If given value is 0)
    table[0] = 1;
 
    // Pick all coins one by one and update the table[] values
    // after the index greater than or equal to the value of the
    // picked coin
	int i, j;
    for(i=0; i<m; i++)
        for(j=S[i]; j<=n; j++)
            table[j] += table[j-S[i]];
 
    return table[n];
}

int main()
{
    int denominations[] = {2, 4, 5};
    int N = 9;
	printf("%d\n", count(denominations, 3, N));
    return 0;
}
