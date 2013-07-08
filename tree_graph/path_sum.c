#include <iostream>
#include <cstdlib>
#include <vector>
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


void print(vector<int> v, int start, int end)
{
    for (int i = start; i <= end; ++i) {
        cout << v[i] << "\t";
    }
    cout << endl;
}

void find_path(node_t *node, int sum, int level, vector<int> v)
{
    if (node == NULL)
        return;
    v.push_back(node->value);
    int tmp = sum;
    for (int i = level; i >= 0; --i) {
        tmp -= v[i];
        if (tmp == 0)
            print(v, i, level);
    }
    find_path(node->left, sum, level + 1, v);
    find_path(node->right, sum, level + 1, v);
}

int main()
{
    int a[N];
    int i;
    for (i = 0; i < N; ++i)
        a[i] = i;
    node_t *root;
    create_binary_tree(a, N, &root);
    
    vector<int> v;
    int sum;
    cin >> sum;
    find_path(root, sum, 0, v);
    return 0;
}
