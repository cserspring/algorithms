/**
 * @brief String - binary search
 */
#include <stdio.h>
#include <string.h>

#define N 10
int get_index(char **str, int l, int r, char *target)
{
    if (target == NULL || !strcmp(target, ""))
        return -1;
    int i, j;
    int mid;
    int cv;
    while (l <= r) {
        while (l <= r && !strcmp(str[r], ""))
            --r;
        if (r < l)
            return -1;
        mid = (l + r)/2;
        while (!strcmp(str[mid], ""))
            ++mid;
        cv = strcmp(str[mid], target);
        if (!cv)
            return mid;
        if (cv > 0)
            r = mid - 1;
        else
            l = mid + 1;
    }
    return -1;
}

int main()
{
    char *str[N] = {"ab", "", "", "bc", "ct", "", "", "ey", "", ""};
    char *target = "ey";
    printf("%d\n", get_index(str, 0, N - 1, target));
    return 0;
}
