#include <iostream>
#include <string.h>
using namespace std;

#define NUM 26

class Node
{
public:
    int count; //记录该处字符串个数
    Node* char_arr[NUM];  //分支
    char* current_str;   //记录到达此处的路径上的所有字母组成的字符串
    Node();
};

class Trie
{
public:
    Node* root;
    Trie();

    void insert(char* str);
    void output(Node* &node, char** str, int& count);
};

//程序未考虑delete动态内存
int main()
{
    char** str = new char*[12];
    str[0] = "zbdfasd";
    str[1] = "zbcfd";
    str[2] = "zbcdfdasfasf";
    str[3] = "abcdaf";
    str[4] = "defdasfa";
    str[5] = "fedfasfd";
    str[6] = "dfdfsa";
    str[7] = "dadfd";
    str[8] = "dfdfasf";
    str[9] = "abcfdfa";
    str[10] = "fbcdfd";
    str[11] = "abcdaf";

    //建立trie树
    Trie* trie = new Trie();
    for(int i = 0; i < 12; i++)
        trie->insert(str[i]);

    int count = 0;
    trie->output(trie->root, str, count);

    for(int i = 0; i < 12; i++)
        cout<<str[i]<<endl;

    return 0;
}

Node::Node()
{
    count = 0;
    for(int i = 0; i < NUM; i++)
        char_arr[i] = NULL;
    current_str = new char[100];
    current_str[0] = '\0';
}

Trie::Trie()
{
    root = new Node();
}

void Trie::insert(char* str)
{
    int i = 0;
    Node* parent = root;

    //将str[i]插入到trie树中
    while(str[i] != '\0')
    {
        //如果包含str[i]的分支存在，则新建此分支
        if(parent->char_arr[str[i] - 'a'] == NULL)
        {
            parent->char_arr[str[i] - 'a'] = new Node();
            //将父节点中的字符串添加到当前节点的字符串中
            strcat(parent->char_arr[str[i] - 'a']->current_str, parent->current_str);

            char str_tmp[2];
            str_tmp[0] = str[i];
            str_tmp[1] = '\0';

            //将str[i]添加到当前节点的字符串中
            strcat(parent->char_arr[str[i] - 'a']->current_str, str_tmp);

            parent = parent->char_arr[str[i] - 'a'];
        }
        else
        {
            parent = parent->char_arr[str[i] - 'a'];
        }
        i++;
    }
    parent->count++;
}

//采用前序遍历
void Trie::output(Node* &node, char** str, int& count)
{
    if(node != NULL)
    {
        if(node->count != 0)
        {
            for(int i = 0; i < node->count; i++)
                str[count++] = node->current_str;
        }
        for(int i = 0; i < NUM; i++)
        {
            output(node->char_arr[i], str, count);
        }

    }
}
