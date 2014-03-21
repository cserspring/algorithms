/**
 * Sort the linkedlist using merge sort.
 */
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int val;
    struct node *next;
} node_t;

node_t *merge(node_t *a, node_t *b);
node_t *get_mid(node_t *root);

node_t *mergesort(node_t *root)
{
    if (root == NULL || root->next == NULL)
        return root;
    node_t *mid = get_mid(root);
    node_t *midnext = mid->next;
    mid->next = NULL;
    return merge(mergesort(root), mergesort(midnext));
}

node_t *merge(node_t *a, node_t *b)
{
    /*
    node_t *head, *root;
    if (a == NULL || b == NULL)
        return (a == NULL) ? b : a;
    if (a->val > b->val) {
        root = head = b;
        b = b->next;
    } else {
        root = head = a;
        a = a->next;
    } 
    while (a != NULL && b != NULL) {
        if (a->val > b->val) {
            head->next = b;
            b = b->next;
        } else {
            head->next = a;
            a = a->next;
        }
        head = head->next;
    }
    head->next = (a == NULL) ? b : a;
    return root;
    */
    node_t *head = (node_t *)malloc(sizeof(node_t));
    node_t *cur = head;
    while (a != NULL && b != NULL) {
        if (a->val > b->val) {
            head->next = b;
            b = b->next;
        } else {
            head->next = a;
            a = a->next;
        }
        head = head->next;
    }   
    head->next = (a == NULL) ? b : a;
    node_t *res = cur->next;
    free(cur);
    return res;
}

node_t *get_mid(node_t *root)
{
    node_t *slow = root;
    node_t *fast = root;
    if (root == NULL)
        return NULL;
    // Move one step forward
    // Move two steps forward, be careful
    while (fast->next != NULL && fast->next->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}

int main()
{
    node_t node1;
    node_t node2;
    node_t node3;
    node_t root;
    node3.val = 9;
    node3.next = NULL;
    node2.val = 3;
    node2.next = &node3;
    node1.val = 5;
    node1.next = &node2;
    root.val = 4;
    root.next = &node1;

    node_t *head = mergesort(&root);
    while (head) {
        printf("%d\n", head->val);
        head = head->next;
    }
}
