#include <stdio.h>
#include <stdlib.h>

#define LEN 8
typedef struct node node_t;

struct node{  
	int val;  
	node_t *next;  
};  

//delete even node
void delete_even_node(node_t* head);

int main()
{
	node_t** arr = (node_t**)malloc(sizeof(node_t*)*LEN);
	arr[0] = (node_t*)malloc(sizeof(node_t));
	arr[0]->val = 0;
	int i;
	for(i = 1; i < LEN; i++)
	{
		arr[i] = (node_t*)malloc(sizeof(node_t));
		arr[i]->val = i;
		arr[i - 1]->next = arr[i];
	}
	arr[LEN - 1]->next = NULL;
	arr[LEN - 1]->val = 7;

	delete_even_node(arr[0]);

	while(arr[0] != NULL)
	{
		printf("%d\n", arr[0]->val);
		arr[0] = arr[0]->next;
	}

	return 0;
}

void delete_even_node(node_t* head)
{
	if(head != NULL)
	{
		//q is after p
		node_t* p = head;
		node_t* q = head->next;

		while(q != NULL)
		{
			p->next = q->next;
			p = q->next;

			free(q);

			if(p != NULL)
				q = p->next;
			else
				q = NULL;
		}
	}
}