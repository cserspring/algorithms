/*
Given two strings where first string may contain wild card characters 
and second string is a normal string. Write a function that returns true
 if the two strings match. The following are allowed wild card characters
 in first string.

* --> Matches with 0 or more instances of any character or set of characters.
? --> Matches with any one character.

For example, “g*ks” matches with “geeks” match. And string 
  “ge?ks*” matches with “geeksforgeeks” (note ‘*’ at the end of first string).
   But “g*k” doesn’t match with “gee” as character ‘k’ is not 
   present in second string.
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

static int equalchar(char a, char b);
int match(char *first, char * second)
{
    // If we reach at the end of both strings, we are done
    if (*first == '\0' && *second == '\0')
        return 1;
 
    // Make sure that the characters after '*' are present in second string.
    // This function assumes that the first string will not contain two
    // consecutive '*' 
    if (*first == '*' && *(first+1) != '\0' && *second == '\0')
        return 0;
 
    // If the first string contains '?', or current characters of both 
    // strings match
    if (*first == '?' || *first == *second)
        return match(first+1, second+1);
 
    // If there is *, then there are two possibilities
    // a) We consider current character of second string
    // b) We ignore current character of second string.
    if (*first == '*')
        return match(first+1, second) || match(first, second+1);
    return 0;
}

int isMatchII(const char *p, const char *s) 
{
    const char* star=NULL;
    const char* ss=s; 
    while (*s){
        if ((*p=='?')||(*p==*s)){s++;p++;continue;}
        if (*p=='*'){star=p++; ss=s;continue;}
        if (star){ p = star+1; s=++ss;continue;}
        return 0;
    }
    while (*p=='*'){p++;}
    return !*p;
}

//dp
int isMatch(const char *p, const char *s)
{
    int plen = strlen(p);
    int slen = strlen(s);
    int i = 0;
    int j = 0;
    int **dp = (int **)malloc((plen+1)*sizeof(int *));
    for (; i <= plen; ++i)
        dp[i] = (int *)malloc(sizeof(int)*(slen+1));
    dp[0][0] = 1;
    for (i = 1; i <= plen; ++i)
        dp[i][0] = p[i-1]=='*' ? dp[i-1][0] : 0;
    for (i = 1; i <= slen; ++i)
        dp[0][i] = 0;
    for (i = 1; i <= plen; ++i) {
        for (j = 1; j <= slen; ++j) {
            if (p[i-1]=='*') 
                dp[i][j] = dp[i-1][j] || dp[i][j-1];
            else 
                dp[i][j] = dp[i-1][j-1] && equalchar(p[i-1], s[j-1]);
        }
    }
    return dp[plen][slen];
}

static int equalchar(char a, char b){
    if (a=='?' || b=='?')
        return 1;
    return a==b;
}

void test(char *first, char *second)
{  
    isMatch(first, second)? puts("Yes"): puts("No"); 
}
 
// Driver program to test above functions
int main()
{
    test("g*ks", "geeks"); // Yes
    test("ge?ks*", "geeksforgeeks"); // Yes
    test("g*k", "gee");  // No because 'k' is not in second
    test("*pqrs", "pqrst"); // No because 't' is not in first
    test("abc*bcd", "abcdhghgbcd"); // Yes
    test("abc*c?d", "abcd"); // No because second must have 2 instances of 'c'
    test("*c*d", "abcd"); // Yes
    test("*?c*d", "abcd"); // Yes
    test("a?cd", "ab123cd"); // No
    return 0;
}
