/**
 * @brief parenthesis match
 */
#include <stdio.h>

void print_paren(int l, int r, char *str, int count)
{
    if (l < 0 || r < l)
        return;
    if (l == 0 && r == 0) {
        printf("%s\n", str);
    } else {
        if (l > 0) {
            str[count] = '(';
            print_paren(l - 1, r, str, count + 1);
        }
        if (r > l) {
            str[count] = ')';
            print_paren(l, r - 1, str, count + 1);
        }
    }
}

int main()
{
    int count = 4;
    char str[count*2 + 1];
    str[count*2] = '\0';
    print_paren(count, count, str, 0);
    return 0;
}
