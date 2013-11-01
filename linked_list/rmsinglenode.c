/**
 * Use the secondary pointer to delete the node
 */
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int val;
    struct node *next;
} node_t;

node_t *create_node(int value, node_t *nextnode)
{
	node_t *newnode = (node_t*)malloc(sizeof(node_t));
	newnode->val = value;
	newnode->next = nextnode;
	return newnode;
}

void delete_node(node_t **root, int val)
{
	node_t **cur = root;
	while (*cur) {
		if((*cur)->val == val) {
			node_t *tmp = *cur;
			*cur = (*cur)->next;
			free(tmp);
		}
		cur = &((*cur)->next);
	}
}

int main()
{
    node_t *tail = create_node(4, NULL);
    node_t *node7 = create_node(1, tail);
    node_t *node6 = create_node(3, node7);
    node_t *node5 = create_node(1, node6);
    node_t *node4 = create_node(3, node5);
    node_t *node3 = create_node(2, node4);
    node_t *node2 = create_node(3, node3);
    node_t *head = create_node(1, node2);
	node_t *root = head;
	delete_node(&root, 1);
	while (root) {
		printf("%d\n", root->val);
		root = root->next;
	}
	return 0;
}
