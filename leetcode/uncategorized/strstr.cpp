#include <cstdlib>

class Solution {
public:
    char *strStr(char *haystack, char *needle) {
		if (!needle || !strlen(needle))
			return haystack;

		if (!haystack || !strlen(haystack))
			return NULL;
		char *p = haystack;
		char *q = needle;
		char *padv = haystack;
		while (*++q)
			padv++;
		q = needle;
		while (*padv) {
			while (*q && *p==*q) {
				p++;
				q++;
			}
			if (!*q)
				return haystack;
			p = ++haystack;
			q = needle;
			padv++;
		}
		return NULL;
    }
};
