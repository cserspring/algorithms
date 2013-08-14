#include <stdio.h>
#include <stdlib.h>
typedef struct node_t* nodeptr;

struct node_t
{
  int min;
  int max;
  nodeptr left;
  nodeptr right;
};

nodeptr create(int min, int max)
{
  nodeptr node;
  if (min < max)
  {
    node = (nodeptr)malloc(sizeof(struct node_t));
    int middle = (min + max)/2;
    node->min = min;
    node->max = max;
    node->left = create(min, middle);
    node->right = create(middle + 1, max);
    return node;
  }
  else if (min == max)
  {
    node = (nodeptr)malloc(sizeof(struct node_t));
    node->min = node->max = min;
    node->left = node->right = NULL;
    return node;
  }
  else
    return NULL;
}

int main()
{
  nodeptr root = create(1, 10);
  printf("%d\n", sizeof(struct node_t));
  printf("%d\n", root->left->left->max);
  return 0;
}
