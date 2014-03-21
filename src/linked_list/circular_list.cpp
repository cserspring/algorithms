/**
 * @brief Find the start node of the loop in the circular list.
 * Method: Iterate through the list, meanwhile, store the visited nodes in a
 *         set. When a node has occured before, then it is the start point.
 */
#include <cstdio>
#include <set>

typedef struct node{
    int data;
    struct node *next;
} node_t;

node_t *get_circular_start_point(node_t *head)
{
    std::set<node_t *> nodeset;
    
    node_t *p = head;
    while (p) {
        if (nodeset.find(p) == nodeset.end()) 
            nodeset.insert(p);
        else
            return p;
        p = p->next;
    }
    return NULL;
}

int main()
{
    node_t tail = {'H', NULL};
    node_t node7 = {'G', &tail};
    node_t node6 = {'F', &node7};
    node_t node5 = {'E', &node6};
    node_t node4 = {'D', &node5};
    node_t node3 = {'C', &node4};
    node_t node2 = {'B', &node3};
    node_t head = {'A', &node2};

    // add a loop
    tail.next = &node4;
    printf("%c\n", get_circular_start_point(&head)->data);
    return 0;
}
