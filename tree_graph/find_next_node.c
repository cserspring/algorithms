/**
 * @brief Find the next node (in order).
 */
#include <stdio.h>
#include <stdlib.h>

#define N 31

typedef struct node {
    int value;
    struct node *parent;
    struct node *left;
    struct node *right;
} node_t;

void create_binary_tree(int *a, int len, node_t **root, node_t *parent)
{
    if (len > 0) {
        int mid = len/2;
        *root = (node_t *)malloc(sizeof(node_t));
        (*root)->parent = parent;
        (*root)->value = a[mid];
        create_binary_tree(a, mid, &(*root)->left, *root);
        create_binary_tree(a + mid + 1, len - mid - 1, &(*root)->right, *root);
    } else {
        *root = NULL;
    }
}

node_t *find_next_node(node_t *src)
{
    node_t *node = src->right;
    node_t *p = NULL;
    if (node != NULL) {
        while (node->left != NULL) {
            node = node->left;
        }
        return node;
    } else {
        while ((p = src->parent) != NULL && p->right == src)
            src = src->parent;
        return p;
    }
}

node_t *find_node(node_t *root, int value)
{
    if (root->value == value)
        return root;
    else if (root->value > value)
        return find_node(root->left, value);
    else 
        return find_node(root->right, value);
}

int main()
{
    int a[N];
    int i;
    for (i = 0; i < N; ++i)
        a[i] = i;
    node_t *root;
    create_binary_tree(a, N, &root, NULL);
    
    int src;
    while (printf("Input between 0 and %d\n", N - 1), scanf("%d", &src) != EOF) {
        node_t *node = find_node(root, src);
        node_t *target;
        if ((target = find_next_node(node)) != NULL)
            printf("%d\n", target->value);
    }
    return 0;
}
