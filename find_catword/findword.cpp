/** @file findword.cpp
 * 
 *  @brief 
 *  1. A trie tree is created to save the sorted words, when a word
 *     is inserted into the tree, the (word, word - prefix) is pushed into a 
 *     queue. The prefix means the word which is in the list.
 *  2. The elements in the queue are poped to check whether a word can be 
 *     constructed by other words.
 *     2.1 If the (word - prefix) is a single word, we can save it in a map
 *     2.2 If the (word - prefix) is not a word, then we can continue to find
 *         the prefix of (word - prefix), and put
 *                   (word, ((word - prefix) - new_prefix))
 *         into the queue.
 *  3. Search on the map to find the longest word, and the size of the map is 
 *     the number of words in the list can be constructed by other words.
 *
 *  @author cserspring
 *  @bugs No known bugs.
 */

#include <iostream>
#include <string>
#include <cstring>
#include <stdio.h>
#include <queue>
#include <utility>
#include <map>
using namespace std;

#define LOWER_CASE_NUM 26
#define LENGTH 100
class Node
{
public:
    bool end_of_word; //whether current char is the end of a word
    Node *char_arr[LOWER_CASE_NUM];//26 branches of the node
    Node();
};

class Trie
{
public:
    Node *root;
    queue<pair<string, string> > pairq;//save pairs of (word, word-prefix)
    map<string, int> wordmap;//save the word which can be constructed by others

    Trie();    
    void find_target();
    void insert(const char *str);
    bool isword(const char *str);
    void addpair(const char *word, const char *str);
};

int main()
{
    char word[LENGTH] = {0};
    Trie *trie =new Trie();
    
    while (scanf("%s", word) != EOF) {
        trie->insert(word);
    }
    trie->find_target();

    int len = 0;
    map<string, int>::iterator target_it;
    for (map<string, int>::iterator it = trie->wordmap.begin(); 
         it != trie->wordmap.end(); it++) {
        if (it->first.length() > len) {
            target_it = it;
            len = it->first.length();
        }
    }
    printf("Longest word: %s\n", target_it->first.c_str());

    printf("%d words in the list can be constructed of other words\n",
           trie->wordmap.size());
    
    return 0;
}

//Constructor of class Node
Node::Node()
{
    end_of_word = false;
    for(int i =0; i < LOWER_CASE_NUM; i++)
        char_arr[i] = NULL;
}

//Constructor of class Trie
Trie::Trie()
{
    root = new Node();
}

//Insert the word into the Trie tree
void Trie::insert(const char* str)
{
    int i =0;
    int index;
    Node *node = root;
    
    while(str[i] !='\0') {
        index = str[i] -'a';
        if(node->char_arr[index] == NULL) {
            node->char_arr[index] = new Node();
        } else if (node->char_arr[index]->end_of_word) {
            //Insert the (word, word - prefix) into the queue
            pairq.push(make_pair(str, str+i+1));
        }
        node = node->char_arr[index];
        i++;
    }
    //The last character indicates the end of the word
    node->end_of_word = true;
}

//Scan from the root of the tree to determine whether the string is a word
bool Trie::isword(const char *str)
{
    int i = 0; 
    Node *node = root;
    int index;
    while (str[i] != '\0') {
        index = str[i] - 'a';
        if (node->char_arr[index] == NULL)
            return false;
        node = node->char_arr[index];
        i++;
    }
    if (node->end_of_word)
        return true;
    return false;
}

//Get the new pair of (word, word - prefix), and insert it into the queue.
void Trie::addpair(const char *word, const char *str)
{
    int i = 0;
    int index;
    Node *node = root;
    
    while(str[i] !='\0') {
        index = str[i] -'a';
        if(node->char_arr[index] == NULL) {
            return;
        } else if (node->char_arr[index]->end_of_word) {
            pairq.push(make_pair(word, str+i+1));
        }

        node = node->char_arr[index];
        i++;
    }
}

//Process the queue to find the words which can be constructed by other words.
void Trie::find_target()
{
    pair<string, string> p;
    while (!pairq.empty()) {
        p = pairq.front();
        pairq.pop();
        if (isword(p.second.c_str()))
            wordmap.insert(make_pair(p.first.c_str(), 1));
        else 
            addpair(p.first.c_str(), p.second.c_str());
    }
}
