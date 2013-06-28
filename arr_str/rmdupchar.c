/**
 * @brief Remove the duplicate chars in the string.
 */
#include <stdio.h>
#include <string.h>
void rmdupchar(char *str)
{
    if (str == NULL)
        return;
    int len = strlen(str);
    if (len < 2)
        return;
    int i;
    int j;
    int prev = 1;
    for (i = 1; i < len; ++i) {
        for (j = 0; j < prev; ++j) {
            if (str[j] == str[i])
                break;
        }
        if (j == prev)
            str[prev++] = str[i];
    }
    str[prev] = str[i];
    printf("%s\n", str);
}

int main()
{
    char str1[] = "abcd";
    char str2[] = "aaaa";
    char str3[] = "aaabbb";
    char str4[] = "abababa";
    char str5[] = "aabzfaefuuuw";
    rmdupchar(str1);
    rmdupchar(str2);
    rmdupchar(str3);
    rmdupchar(str4);
    rmdupchar(str5);
    rmdupchar(NULL);
    return 0;
}
