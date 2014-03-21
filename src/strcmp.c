#include <stdio.h>

int strcmp2(const char *s1, const char *s2)
{
    if (!s1 && !s2)
        return 0;
    if (!s1 || !s2)
        return (!s1) ? 1 : -1;
    int i = 0;
    while (s1[i] != '\0' || s2[i] != '\0') {
        if (s1[i] == s2[i]) {
            ++i;
            continue;
        }
        return s1[i] > s2[i] ? 1 : -1;
    }
    return 0;
}

int main()
{
    char *s = "a";
    int a = strcmp2("aabcd", "abc");
    printf("%d\n", a);
    return 0;
}
