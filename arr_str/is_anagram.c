/**
 * @brief Determine whether the two words are anagrams.
 * I. Sort the chars in words, and see whether they are the same.
 * II. Use map to solve this problem.
 * III. This program is written in C, we use an array to solve it.
 */
#include <stdio.h>
#include <string.h>

#define NUM 256
#define INPUT_LEN 256

int is_anagram(char *word1, char *word2)
{
    int len1 = strlen(word1);
    int len2 = strlen(word2);
    if (len1 != len2)
        return 0;
    int count[NUM] = {0};
    int i;
    for (i = 0; i < len1; ++i) {
        ++count[word1[i]];
        --count[word2[i]];
    }

    for (i = 0; i < NUM; ++i) {
        if (count[i] != 0)
            return 0;
    }
    
    return 1;
}

int main()
{
    char s1[INPUT_LEN];
    char s2[INPUT_LEN];
    scanf("%s%s", s1, s2);
    printf("%s\n", is_anagram(s1, s2) ? "TRUE" : "FALSE");
    return 0;
}
