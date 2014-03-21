/**
 * @brief Whether a tree is a subtree of another tree.
 */
#include <stdio.h>
#include <stdlib.h>

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

/* root1 is the bigger tree, root2 is the smaller tree */
int is_subtree(node_t *root1, node_t *root2)
{
    if (root2 == NULL)
        return 1;
    if (root1 == NULL)
        return 0;
    if (root1->value == root2->value)
        return is_subtree(root1->left, root2->left) && 
            is_subtree(root1->right, root2->right);
    else 
        return is_subtree(root1->left, root2) || is_subtree(root1->right, root2);
}

int main()
{
    int num1 = 8;
    int num2 = 3;
    int a[num1];
    int b[num2];
    int i;
    for (i = 0; i < num1; ++i)
        a[i] = i;
    for (i = 0; i < num2; ++i)
        b[i] = i;
    node_t *root1, *root2;
    create_binary_tree(a, num1, &root1);
    create_binary_tree(b, num2, &root2);
    
    printf("%s\n", is_subtree(root1, root2) ? "True" : "False");
    return 0;
}
