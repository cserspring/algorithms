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

int isMatch(const char *p, const char *s) 
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

void test(char *first, char *second)
{  
    match(first, second)? puts("Yes"): puts("No"); 
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