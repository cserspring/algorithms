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

node_t *delete_node(node_t *root, node_t *target)
{
	if (target == NULL)
		return root;

	if (target->left && target->right) {
		node_t *successor = find_next_node(target);
		target->value = successor->value;
		target = successor;
	}
	node_t *l = target->left;
	node_t *r = target->right;
	node_t *p = target->parent;

	if (!l && !r) {
		if (p == NULL) {
			free(target);
			return NULL;
		}
		if (target == p->left)
			p->left = NULL;
		else
			p->right = NULL;
		free(target);
	} else if (!l || !r) {
		node_t *tmp = (l == NULL) ? r : l;
		if (p == NULL) {
			free(target);
			return tmp;
		}
		if (target == p->left)
			p->left = tmp;
		else
			p->right = tmp;
		free(target);
	}
	return root;
}

void print(node_t *root)
{
	if (root) {
		print(root->left);
		printf("%d\n", root->value);
		print(root->right);
	}
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
	node_t *target = find_node(root, 15);
	node_t *head = delete_node(root, target);
	print(head);
    return 0;
}
