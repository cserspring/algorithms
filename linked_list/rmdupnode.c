/**
 * @brief Remove the duplicate nodes (have the same data value) 
 * in a linked list.
 */
#include <stdio.h>

typedef struct node{
    int data;
    struct node *next;
} node_t;

void rmdup(node_t *head)
{
    if (head == NULL)
        return;
    node_t *prev = head;
    node_t *p = head->next;
    node_t *q;
    int removed = 0;
    while (p) {
        q = head;
        removed = 0;
        while (q != p) {
            if (q->data == p->data) {
                prev->next = p->next;
                removed = 1;
                break;
            } else {
                q = q->next;
            }
        }
        // if removed, previous node before p should not be changed
        if (!removed)
            prev = p;
        p = p->next;
    }
}

int main()
{
    node_t tail = {3, NULL};
    node_t node7 = {1, &tail};
    node_t node6 = {3, &node7};
    node_t node5 = {1, &node6};
    node_t node4 = {3, &node5};
    node_t node3 = {2, &node4};
    node_t node2 = {3, &node3};
    node_t head = {1, &node2};
    rmdup(&head);

    node_t *node = &head;
    while (node) {
        printf("%d\n", node->data);
        node = node->next;
    }

    return 0;
}
