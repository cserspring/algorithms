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

void preorder(node_t *root)
{
    if (root) {
        printf("%d\t", root->value);        
        preorder(root->left);
        preorder(root->right);
    }
}

void preorder_nonrecursive(node_t *root)
{
    if (!root)
        return;
    node_t *stack[N];
    int top = -1;
    stack[++top] = root;
    while (top > -1) {
        node_t *node = stack[top];
        printf("%d\t", stack[top--]->value);
        if (node->right != NULL)
            stack[++top] = node->right;
        if (node->left != NULL)
            stack[++top] = node->left;
    }
}

void inorder(node_t *root)
{
    if (root) {
        inorder(root->left);
        printf("%d\t", root->value);
        inorder(root->right);
    }
}

void inorder_nonrecursive(node_t *root)
{
    node_t *stack[N];
    int top = -1;
    while (root || top > -1) {
        while (root) {
            stack[++top] = root;
            root = root->left;
        }
        root = stack[top--];
        printf("%d\t", root->value);
        root = root->right;
    }
}

void inorder_nonrecursive_2(node_t *root)
{
    node_t *stack[N];
    int top = -1;
    while (root || top > -1) {
        if (!root) {
            root = stack[top--];
            printf("%d\t", root->value);
            root = root->right;
        }
        if (root) {
            stack[++top] = root;
            root = root->left;
        }
    }
}

void postorder(node_t *root)
{
    if (root) {
        postorder(root->left);
        postorder(root->right);
        printf("%d\t", root->value);
    }
}

void postorder_nonrecursive(node_t *root)
{
    if (!root)
        return;
    node_t *stack1[N];
    node_t *stack2[N];
    int top1 = -1;
    int top2 = -1;
    stack1[++top1] = root;
    while (top1 > -1) {
        node_t *node = stack1[top1--];
        stack2[++top2] = node;
        if (node->left)
            stack1[++top1] = node->left;
        if (node->right)
            stack1[++top1] = node->right;
    }

    while (top2 > -1)
        printf("%d\t", stack2[top2--]->value);
}

void postorder_nonrecursive_2(node_t *root)
{
    if (!root)
        return;
    node_t *stack[N];
    int top = -1;
    node_t *current = root;
    node_t *prev = NULL;
    stack[++top] = current;
    while (top > -1) {
        current = stack[top];
        if (!prev || prev->left == current || prev->right == current) {
            if (current->left) {
                stack[++top] = current->left;
            } else if (current->right) {
                stack[++top] = current->right;
            } else {
                printf("%d\t", current->value);
                --top;
            }
        } else if (current->left == prev) {
            if (current->right) {
                stack[++top] = current->right;
            } else {
                printf("%d\t", current->value);
                --top;
            }
        } else if (current->right == prev) {
            printf("%d\t", current->value);
            --top;
        }
        prev = current;
    }
}

int main()
{
    int a[N];
    int i;
    for (i = 0; i < N; ++i)
        a[i] = i;
    node_t *root;
    create_binary_tree(a, N, &root);
    printf("preorder:\n");
    preorder(root);
    printf("\n");
    preorder_nonrecursive(root);
    printf("\n");

    printf("inorder:\n");
    inorder(root);
    printf("\n");
    inorder_nonrecursive(root);
    printf("\n");
    inorder_nonrecursive_2(root);
    printf("\n");

    printf("postorder:\n");
    postorder(root);
    printf("\n");
    postorder_nonrecursive(root);
    printf("\n");
    postorder_nonrecursive_2(root);
    printf("\n");

    return 0;
}
