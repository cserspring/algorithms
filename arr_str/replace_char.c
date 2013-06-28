/**
 * @brief Replace space with "%20"
 * Count the number of spaces, then allocate a new string whose lenght is
 * len + 2*count.
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define INPUT_LEN 256

char *replace_space(char *str)
{
    int len = strlen(str);
    int i;
    int count = 0;
    for (i = 0; i < len; ++i) {
        if (str[i] == 0x20)
            ++count;
    }

    int newlen = len + 2*count;
    char *newstr = (char *)malloc(sizeof(char)*newlen + 1);
    newstr[newlen] = '\0';
    for (i = len - 1; i >= 0; --i) {
        if (str[i] == 0x20) {
            newstr[--newlen] = '0';
            newstr[--newlen] = '2';
            newstr[--newlen] = '%';
        } else {
            newstr[--newlen] = str[i];
        }
    }
    return newstr;
}

int main()
{
    char input[INPUT_LEN];
    scanf("%[^\n]", input);
    char *result = replace_space(input);
    printf("%s\n", result);
    free(result);
    return 0;
}
