#include <iostream>
#include <stack>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

class Node
{
public:
       char* data;
       Node* left;
       Node* right;
       int balance;
       int count;
       Node()
       {
               data = NULL;
               left = right = NULL;
               balance = count = 0;
       }
       Node(char* s)
       {
               data = new char[30];
	       strcpy(data, s);
               left = NULL;
               right = NULL;
               balance = 0;
               count = 1;
       }
};


class AVLTree
{
private:
       Node* root;

public:
       int vertexNumber;
       AVLTree()
       {
               root = NULL;
               vertexNumber = 0;
       }


       AVLTree(Node* r)
       {
               root = r;
               vertexNumber = 0;
       }
       int depth(Node* node)
       {
               if(node == NULL)
                       return -1;
               int l = depth(node->left);
               int r = depth(node->right);

               return (l < r)?(r+1):(l+1);
       }

       void insert(char* str)
       {
               Node* child = root;
               Node* parent = NULL;
               Node* grandpa = NULL;
               int flag;
               stack<Node*> st;

               if(root == NULL)
               {
                       Node* no = new Node(str);
                       root = no;
                       return;
               }

               while(child != NULL)
               {
                       if(strcmp(str, child->data) == 0)
                       {
                               (child->count)++;
                               return;
                       }

                       parent = child;
                       st.push(parent);
                       if(strcmp(str, child->data) < 0)
                               child = parent->left;
                       else 
                               child = parent->right;
               }

               Node* node = new Node(str);
               if(strcmp(node->data, parent->data) < 0)
                       parent->left = node;
               else 
                       parent->right = node;

               while(!st.empty())
               {
                       parent = st.top();
                       st.pop();
                       if(parent->left == node)
                               parent->balance += 1;
                       else
                               parent->balance -= 1;

                       if(parent->balance == 0)
                               break;
                       else if(parent->balance == -1 || parent->balance == 1)
                               node = parent;
                       else
                       {
                               flag = (parent->balance < 0)? -1 : 1;
                               if(node->balance == flag)
                               {
                                       if(flag == -1)
                                               leftRotate(parent);
                                       else
                                               rightRotate(parent);
                               }
                               else
                               {
                                       if(parent->balance == -2)
                                               rightLeftRotate(parent);
                                       else
                                               leftRightRotate(parent);
                               }
                               break;
                       }
               }

               if(st.empty())
                       root = parent;
               else
               {
                       grandpa = st.top();

					   if(strcmp(grandpa->data, parent->data) > 0)
						   grandpa->left = parent;
					   else
						   grandpa->right = parent;
               }
       }

       void leftRotate(Node* &node)
       {
               Node* temp = node;
               node = node->right;
               temp->right = node->left;
               node->left = temp;
               temp->balance = node->balance = 0;
       }

       void rightRotate(Node* &node)
       {
               Node* temp = node;
               node = node->left;
               temp->left = node->right;
               node->right = temp;
               temp->balance = node->balance = 0;
       }

       void leftRightRotate(Node* &node)
       {
               Node* rightChild = node;
               Node* leftChild = node->left;

               node = leftChild->right;
               leftChild->right = node->left;
               node->left = leftChild;

               if(node->balance <0 )
                       leftChild->balance = 1;
               else
                       leftChild->balance = 0;

               rightChild->left = node->right;
               node->right = rightChild;

               if(node->balance <=0)
                       rightChild->balance = 0;
               else
                       rightChild->balance = -1;

               node->balance = 0;
       }

       void rightLeftRotate(Node* &node)
       {
               Node* leftChild = node;
               Node* rightChild = node->right;

               node = rightChild->left;
               rightChild->left = node->right;
               node->right = rightChild;

               if(node->balance <= 0 )
                       rightChild->balance = 0;
               else
                       rightChild->balance = -1;

               leftChild->right = node->left;
               node->left = leftChild;

               if(node->balance <0)
                       leftChild->balance = 1;
               else
                       leftChild->balance = 0;

               node->balance = 0;
       }

       void print(Node* node)
       {
               if(node != NULL)
			   {
				   print(node->left);
				   printf("%s %.4f\n", node->data, (double)(node->count)*100/vertexNumber);
				   print(node->right);
			   }
       }

       Node* getRoot()
       {
               return root;
       }
};

int main()
{
  /*AVLTree* avlTree = new AVLTree();

       char str[30];
       int i = 0;
       while(gets(str) != NULL)
       {
               avlTree->insert(str);
               (avlTree->vertexNumber)++;

               if(++i == 29)
                       break;
       }
       avlTree->print(avlTree->getRoot());*/
       	
       AVLTree* avlTree = new AVLTree();
       FILE* fp;
       char str[30];
       const char* filename = "input.txt";
       if((fp = fopen(filename, "r")) == NULL)
       {
               printf("NO\n");
               exit(1);
       }

       while(gets(str) > 0)
       {
               avlTree->insert(str);
               (avlTree->vertexNumber)++;
       }
       avlTree->print(avlTree->getRoot());
	   
       return 0;
}
