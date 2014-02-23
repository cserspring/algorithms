/*
Given two strings where first string may contain wild card characters 
and second string is a normal string. Write a function that returns true
 if the two strings match. The following are allowed wild card characters
 in first string.

* --> Matches with 0 or more instances of any character or set of characters.
? --> Matches with any one character.
For example, “g*ks” matches with “geeks” match. And string “ge?ks*” matches with 
“geeksforgeeks” (note ‘*’ at the end of first string). But “g*k” doesn’t match with
 “gee” as character ‘k’ is not present in second string.
 */
#include <stdio.h>
bool match(char *first, char * second)
{
    // If we reach at the end of both strings, we are done
    if (*first == '\0' && *second == '\0')
        return true;
 
    // Make sure that the characters after '*' are present in second string.
    // This function assumes that the first string will not contain two
    // consecutive '*' 
    if (*first == '*' && *(first+1) != '\0' && *second == '\0')
        return false;
 
    // If the first string contains '?', or current characters of both 
    // strings match
    if (*first == '?' || *first == *second)
        return match(first+1, second+1);
 
    // If there is *, then there are two possibilities
    // a) We consider current character of second string
    // b) We ignore current character of second string.
    if (*first == '*')
        return match(first+1, second) || match(first, second+1);
    return false;
}

bool isMatch(const char *s, const char *p) 
{
	// Start typing your C/C++ solution below
	// DO NOT write int main() function
    
	const char* star=NULL;
	const char* ss=s; 
	while (*s){
		if ((*p=='?')||(*p==*s)){s++;p++;continue;}
		if (*p=='*'){star=p++; ss=s;continue;}
		if (star){ p = star+1; s=++ss;continue;}
		return false;
	}
	while (*p=='*'){p++;}
	return !*p;
}

/*
bool isMatch(const char *s, const char *p) {
    int n=strlen(s), m=strlen(p), i, j, chars=0;
    for(i=0; p[i]!='\0'; ++i) 
		if(p[i]!='*' && n<++chars) 
			return false;
    vector<bool> dp(n+2,false);
    for(i=m-1, dp[n]=true; i>=0; --i){
        if(p[i]=='*'){
            while(i>0 && p[i]==p[i-1]) --i; //skip multiple *
            for(j=n; j>=0 && !dp[j]; --j);
            for(; j>=0; --j) dp[j]=true;
        }else{
            for(j=0; j<n+1; ++j)
                dp[j]=(p[i]==s[j] || p[i]=='?') ? dp[j+1] : false;
        }
    }
    return dp[0];
}
*/
 
// A function to run test cases
void test(char *first, char *second)
{  match(first, second)? puts("Yes"): puts("No"); }
 
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
	char s[] = "abcacba";
	char p[] = "*ac";
	if (isMatch(s, p))
		printf("True\n");
    return 0;
}
