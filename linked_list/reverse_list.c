#include <stdio.h>

typedef struct node {
    int val;
    struct node *next;
} node_t;

/* Pass pointer's pointer */
node_t *reverse_list(node_t *root)
{
    if (root) {
        node_t *prev = root;
        node_t *current = root->next;
        prev->next = NULL;
        node_t *tmp;
        while (current) {
            tmp = prev;
            prev = current;
            current = current->next;
            prev->next = tmp;
        }
        root = prev;
    }
    return root;
}

int main()
{
    node_t node1;
    node_t node2;
    node_t root;
    node2.val = 6;
    node2.next = NULL;
    node1.val = 5;
    node1.next = &node2;
    root.val = 4;
    root.next = &node1;
    
    node_t *head = &root;
    head = reverse_list(head);
    while (head) {
        printf("%d\n", head->val);
        head = head->next;
    }
}
