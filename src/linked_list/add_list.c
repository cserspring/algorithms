/**
 * @brief add two list as decimal plus.
 */
#include <stdio.h>
#include <stdlib.h>

#define DECIMAL 10

typedef struct node{
    int data;
    struct node *next;
} node_t;

// common approach
node_t *add_list(node_t *head1, node_t *head2)
{
    int sum = 0;
    int carry = 0;
    int remain = 0;
    node_t *head = NULL;
    node_t *prev = NULL;
    node_t *node = NULL;
    int is_head = 1;
    while (head1 != NULL || head2 != NULL) {
        node = (node_t *)malloc(sizeof(node_t));        
        sum = carry;
        if (head1 != NULL) {
            sum += head1->data;
            head1 = head1->next;
        }
        if (head2 != NULL) {
            sum += head2->data;
            head2 = head2->next;
        }
        carry = sum / DECIMAL;
        remain = sum % DECIMAL;
        node->data = remain;
        node->next = NULL;
        if (is_head) {
            head = node;
            is_head = 0;
        } else {
            prev->next = node;
        }
        prev = node;
    }
    if (carry != 0) {
        node = (node_t *)malloc(sizeof(node_t));
        node->data = carry;
        node->next = NULL;
        prev->next = node;
    }
    return head;
}

// better, recursive
node_t *add_list2(node_t *head1, node_t *head2, int carry)
{
    if (head1 == NULL && head2 == NULL && carry == 0)
        return NULL;
    node_t *next1 = NULL;
    node_t *next2 = NULL;
    if (head1 != NULL) {
        carry += head1->data;
        next1 = head1->next;
    }
    if (head2 != NULL) {
        carry += head2->data;
        next2 = head2->next;
    }

    node_t *node = (node_t *)malloc(sizeof(node_t));
    node->data = carry % DECIMAL;
    node->next = add_list2(next1, next2, carry/DECIMAL);
    return node;
}


int main()
{
    /**
     * 1 3 2 3 1 3 1 3  +
     * 9 9 9 9 9 9 2 9
     */
    node_t tail1 = {3, NULL};
    node_t node7 = {1, &tail1};
    node_t node6 = {3, &node7};
    node_t node5 = {1, &node6};
    node_t node4 = {3, &node5};
    node_t node3 = {2, &node4};
    node_t node2 = {3, &node3};
    node_t head1 = {1, &node2};

    node_t tail2 = {9, NULL};
    node_t node14 = {2, &tail2};
    node_t node13 = {9, &node14};
    node_t node12 = {9, &node13};
    node_t node11 = {9, &node12};
    node_t node10 = {9, &node11};
    node_t node9 = {9, &node10};
    node_t head2 = {9, &node9};

    //node_t *head = add_list(&head1, &head2); 
    node_t *head = add_list2(&head1, &head2, 0);
    while (head) {
        printf("%d\n", head->data);
        head = head->next;
    }
    return 0;
}
