/**
 * @brief To determine whether a tree is a balanced tree.
 */
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    struct node *child;
    struct node *sibling;
    int value;
} node_t;

typedef struct tree {
    node_t *root;
} tree_t;

int max_height(node_t *root)
{
    int height;
    int tmp;
    node_t *node = NULL;
    if (root != NULL) {
        height = max_height(root->child);
        if (root->child != NULL)
            node = root->child->sibling;
        while (node) {
            if (height < (tmp = max_height(node)))
                height = tmp;
            node = node->sibling;
        }
        return 1 + height;
    }
    return 0;
}

int min_height(node_t *root)
{
    int height;
    int tmp;
    node_t *node = NULL;
    if (root != NULL) {
        height = min_height(root->child);
        if (root->child != NULL)
            node = root->child->sibling;
        while (node) {
            if (height > (tmp = min_height(node)))
                height = tmp;
            node = node->sibling;
        }
        return 1+ height;
    }
    return 0;
}

int main()
{
    tree_t *tree = (tree_t *)malloc(sizeof(tree_t));
    node_t *root = (node_t *)malloc(sizeof(node_t));
    root->child = root->sibling = NULL;
    root->value = 0;
    node_t *node1 = (node_t *)malloc(sizeof(node_t));
    node1->child = node1->sibling = NULL;
    node1->value = 1;
    node_t *node2 = (node_t *)malloc(sizeof(node_t));
    node2->child = node2->sibling = NULL;
    node2->value = 2;
    node_t *node3 = (node_t *)malloc(sizeof(node_t));
    node3->child = node3->sibling = NULL;
    node3->value = 3;
    node_t *node4 = (node_t *)malloc(sizeof(node_t));
    node4->child = node4->sibling = NULL;
    node4->value = 4;
    node_t *node5 = (node_t *)malloc(sizeof(node_t));
    node5->child = node5->sibling = NULL;
    node5->value = 5;
    node_t *node6 = (node_t *)malloc(sizeof(node_t));
    node6->child = node6->sibling = NULL;
    node6->value = 6;
    node_t *node7 = (node_t *)malloc(sizeof(node_t));
    node7->child = node7->sibling = NULL;
    node7->value = 7;
    node_t *node8 = (node_t *)malloc(sizeof(node_t));   
    node8->child = node8->sibling = NULL;
    node8->value = 8;
    node_t *node9 = (node_t *)malloc(sizeof(node_t));
    node9->child = node9->sibling = NULL;
    node9->value = 9;

    tree->root = root;
    root->child = node1;
    node1->sibling = node2;
    node2->sibling = node3;
    node1->child = node4;
    node4->sibling = node5;
    node5->sibling = node6;
    node2->child = node7;
    node7->sibling = node8;
    //node3->child = node9;
    node8->sibling = node9;

    printf("Max Height: %d\n", max_height(tree->root));
    printf("Min Height: %d\n",min_height(tree->root));
    return 0;
}
