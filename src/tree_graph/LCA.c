/**
 * @brief Find LCA.
 * Although the tree is a binary search tree, we use it as a binary tree.
 */
#include <stdio.h>
#include <stdlib.h>

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

node_t *LCA(node_t *root, node_t *node1, node_t *node2)
{
    if (root == NULL || node1 == NULL || node2 == NULL)
        return NULL;
    if (root == node1 || root == node2)
        return root;

    node_t *left = LCA(root->left, node1, node2);
    node_t *right = LCA(root->right, node1, node2);
    if (left != NULL && right != NULL)
        return root;
    return (left != NULL) ? left : right;
}

node_t *find_node(node_t *root, int value)
{
    if (value > 30 || value < 0)
        return NULL;
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
    create_binary_tree(a, N, &root);
    
    int v1, v2;
    while (printf("Input between 0 and %d\n", N - 1), 
           scanf("%d%d", &v1, &v2) != EOF) {
        node_t *node1 = find_node(root, v1);
        node_t *node2 = find_node(root, v2);
        node_t *target = LCA(root, node1, node2);
        if (target)
            printf("%d\n", target->value);
    }
    return 0;

}
