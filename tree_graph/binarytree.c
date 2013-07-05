/**
 * @brief Given an sorted array to create a binary tree with minimal height.
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

void inorder(node_t *root)
{
    if (root != NULL) {
        inorder(root->left);
        printf("%d\n", root->value);
        inorder(root->right);
    }
}

int get_depth(node_t *root)
{
    if (root != NULL) {
        int left = 1 + get_depth(root->left);
        int right = 1 + get_depth(root->right);
        return left > right ? left : right;
    }
    return 0;
}

int main()
{
    int a[N];
    int i;
    for (i = 0; i < N; ++i)
        a[i] = i;
    node_t *root;
    create_binary_tree(a, N, &root);
    inorder(root);
    printf("Depth: %d\n", get_depth(root));
    return 0;
}
