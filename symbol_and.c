/* Actually, this program calculates the number of odd bits 
 * in a binary number 
 */
#include <stdio.h>

int main()
{
    int count = 0;
    int countx = 9999;

    while(countx)
    {
        count++;
        countx = countx&(countx - 1);
    }
    printf("%d\n", count);
}
