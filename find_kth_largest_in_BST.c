#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

struct Node {
    int val;
    struct Node *left;
    struct Node *right;
};
typedef struct Node node_t;

void find_by_inorder(node_t *root, int *count, node_t **result, int k)
{
    if (root != NULL) {
        find_by_inorder(root->right, count, result, k);
        (*count)++;
        if (*count == k) {
            *result = root;
            return;
        }
        find_by_inorder(root->left, count, result, k);
    }
}

node_t *make_node(int n) {
    node_t *node = malloc(sizeof(node_t));
    node->left = NULL;
    node->right = NULL;
    node->val = n;
    return node;
}

int main(int argc, char **argv) {
    node_t *node;
    node_t *t1 = make_node(1);
    node_t *t2 = make_node(2);
    node_t *t3 = make_node(3);
    node_t *t4 = make_node(4);
    node_t *t5 = make_node(5);
    node_t *t6 = make_node(6);
    t2->left = t1;
    t2->right = t3;
    t4->left = t2;
    t4->right = t5;
    t5->right = t6;
    node_t *result = NULL;
    int count = 0;
    int i;
    for (i = 0; i < 10; i++) {
        find_by_inorder(t4, &count, &result, i);
        if (result != NULL)
            printf("%dth: %d\n", i, result->val);
        result = NULL;
        count = 0;
    }
    return 0;
}
