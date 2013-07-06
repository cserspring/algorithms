/**
 * @brief Get the nodes in every level.
 */
#include <iostream>
#include <vector>
#include <list>
#include <cstdlib>
using namespace std;

#define N 31

typedef struct node {
    int value;
    struct node *left;
    struct node *right;
} node_t;

void create_binary_tree(int *a, int len, node_t **root)
{
    if (len > 0) {
        int mid = len/2;
        *root = (node_t *)malloc(sizeof(node_t));
        (*root)->value = a[mid];
        create_binary_tree(a, mid, &(*root)->left);
        create_binary_tree(a + mid + 1, len - mid - 1, &(*root)->right);
    } else {
        *root = NULL;
    }
}

vector<list<node_t *> > getlist(node_t *root)
{
    vector<list<node_t *> > vlist;
    list<node_t *> l;
    l.push_back(root);
    vlist.push_back(l);
    
    while (!l.empty()) {
        list<node_t *> tmp;
        for (list<node_t *>::iterator it = l.begin(); it != l.end(); ++it) {
            if ((*it)->left != NULL)
                tmp.push_back((*it)->left);
            if ((*it)->right != NULL)
                tmp.push_back((*it)->right);
        }
        vlist.push_back(tmp);
        l = tmp;
    }
    return vlist;
}


int main()
{
    int a[N];
    int i;
    for (i = 0; i < N; ++i)
        a[i] = i;
    node_t *root;
    create_binary_tree(a, N, &root);
    vector<list<node_t *> > vlist = getlist(root);
    for (int i = 0; i < vlist.size(); ++i) {
        for (list<node_t *>::iterator it = vlist[i].begin(); 
             it != vlist[i].end(); 
             ++it)
            cout << (*it)->value << "\t";
        cout << endl;
    }
    return 0;
}
