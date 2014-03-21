/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/* Recursive
 * Whether the next character of p is '*'
 */
/*
int isMatch(const char *s, const char *p) 
{
    if (*p == 0) 
        return *s == 0;
    if (*(p+1) != '*') {
        if (*s != 0 && (*p == *s || *p == '.')) 
            return isMatch(s+1, p+1);
        else 
            return 0;
    } else {
        // *s == *p
        while (*s != 0 && (*s == *p || *p == '.')) {
            if (isMatch(s, p+2)) 
                return 1;
            s++;
        }
        return (isMatch(s, p+2));
    }
}
*/
static int match(char a, char b)
{
    if (a == '.' || b == '.')
        return 1;
    return a==b;
}

int isMatch(const char *s, const char *p) 
{
    if (!s || !p)
        return 0;
    int m = strlen(s) + 1;
    int n = strlen(p) + 1;
    int i, j;
    int **dp = (int **)malloc(m*sizeof(int *));
    for (i = 0; i < m; ++i) 
        dp[i] = (int *)malloc(n*sizeof(int));
    dp[0][0] = 1;
    for (i = 1; i < n; ++i)
        dp[0][i] = p[i-1] == '*' ? dp[0][i-2] : 0;
    for (i = 1; i < m; ++i)
        dp[i][0] = 0;

    for (i = 1; i < m; ++i) {
        for (j = 1; j < n; ++j) {
            if (p[j-1] == '*') {
                dp[i][j] = match(s[i-1], p[j-2]) ? 
                    (dp[i-1][j] || dp[i][j-2]) : dp[i][j-2];
            } else {
                dp[i][j] = match(s[i-1], p[j-1]) ?
                    dp[i-1][j-1] : 0;
            }
        }
    }
    return dp[m-1][n-1];
}

int main()
{
    //  aaab配a*ab 和 babc配.*c
    //printf("%s\n", isMatch("abc", ".*") ? "Yes" : "No");
    //printf("%s\n", isMatch("aaab", "a*ab") ? "Yes" : "No");
    //printf("%s\n", isMatch("babc", ".*c") ? "Yes" : "No");

    printf("%s\n", isMatch("a", ".*") ? "Yes" : "No");
}
