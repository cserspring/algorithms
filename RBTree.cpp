//1）每个结点要么是红的，要么是黑的。
//2）根结点是黑的。
//3）每个叶结点，即空结点（NIL）是黑的。
//4）如果一个结点是红的，那么它的俩个儿子都是黑的。
//5）对每个结点，从该结点到其子孙结点的所有路径上包含相同数目的黑结点。


#include <iostream>
using namespace std;

enum COLOR {BLACK, RED};

template<class T>
class Node
{
public:
	COLOR color;
	T key;
	Node<T>* left;
	Node<T>* right;
	Node<T>* parent;
	Node();
};

template<class T>
Node<T>::Node()
{
	left = right = parent = NULL;
	color = BLACK;
}

template<class T>
class Tree
{
public:
	Node<T>* root;
	void leftRotate(Node<T>* x);
	void rightRotate(Node<T>* x);
	void RBInsert(Node<T>* z);
	void RBDelete(Node<T>* z);
	Tree();
private:
	Node<T>* NIL;
	void RBInsertFixUp(Node<T>* z);
	void RBDeleteFixUp(Node<T>* z);
	Node<T>* getSuccessor(Node<T>* node);
	Node<T>* getMinimum(Node<T>* node);
};

template<class T>
Tree<T>::Tree()
{
	NIL = new Node<T>();
	NIL->color = BLACK;
	NIL->left = NULL;
	NIL->right = NULL;
	NIL->parent = NULL;
	root = NIL;
}

//做左旋转的时候，总共有六步
//y是x的右孩子
//1.将y的左孩子赋给x的右孩子
//2.如果y的左孩子不为NIL，则把y的左孩子的父亲节点赋值为x
//3.将x的父亲节点赋值给y的父亲节点
//4.决定y的位置
//5.将y的左孩子赋值为x
//6.将x的父亲节点赋值为y
template<class T>
void Tree<T>::leftRotate(Node<T>* x)
{
	if (x->right != NIL)
	{
		Node<T>* y = x->right;
		x->right = y->left;

		if (y->left != NIL)
			y->left->parent = x;
		y->parent = x->parent;

		if (x->parent == NIL)
			root = y;
		else if (x == x->parent->left)
			x->parent->left = y;
		else
			x->parent->right = y;

		y->left = x;
		x->parent = y;
	}
}

template<class T>
void Tree<T>::rightRotate(Node<T>* x)
{
	if (x->left != NIL)
	{
		Node<T>* y = x->left;
		x->left = y->right;

		if (y->right != NIL)
			y->right->parent = x;
		y->parent = x->parent;

		if (x->parent == NIL)
			root = y;
		else if (x == x->parent->right)
			x->parent->right = y;
		else
			x->parent->left = y;

		y->right = x;
		x->parent = y;
	}
}

//插入操作，不断往下找，找到插入点，然后对相应属性赋值
template<class T>
void Tree<T>::RBInsert(Node<T>* z)
{
	Node<T>* y = NIL;
	Node<T>* x = root;

	while (x != NIL)
	{
		y = x;
		if (z->key < x->key)
			x = x->left;
		else
			x = x->right;
	}
	z->parent = y;

	if (y == NIL)
		root = z;
	else if (z->key < y->key)
		y->left = z;
	else
		y->right = z;

	z->left = NIL;
	z->right = NIL;
	z->color = RED;
	RBInsertFixUp(z);
}

template<class T>
void Tree<T>::RBInsertFixUp(Node<T>* z)
{
	while (z->parent->color == RED)
	{
		if (z->parent == z->parent->parent->left)
		{
			Node<T>* y = z->parent->parent->right;
			if (y->color == RED)
			{
				z->parent->color = BLACK;
				y->color = BLACK;
				z->parent->parent->color = RED;
				z = z->parent->parent;
			}
			else if (z == z->parent->right)
			{
				z = z->parent;
				leftRotate(z);
			}
			else
			{
				z->parent->color = BLACK;
				z->parent->parent->color = RED;
				rightRotate(z->parent->parent);
			}
		}
		else
		{
			Node<T>* y = z->parent->parent->left;
			if (y->color == RED)
			{
				z->parent->color = BLACK;
				y->color = BLACK;
				z->parent->parent->color = RED;
				z = z->parent->parent;
			}
			else if (z == z->parent->left)
			{
				z = z->parent;
				rightRotate(z);
			}
			else
			{
				z->parent->color = BLACK;
				z->parent->parent->color = RED;
				leftRotate(z->parent->parent);
			}
		}
	}
	root->color = BLACK;
}

template<class T>
void Tree<T>::RBDelete(Node<T>* z)
{
	Node<T>* y;
	if (z->left == NIL || z->right == NIL)
		y = z;
	else
		y = getSuccessor(z);

	Node<T>* x;
	if (y->left != NIL)
		x = y->left;
	else
		x = y->right;

	x->parent = y->parent;

	if (y->parent == NIL)
		root = x;
	else if (y == y->parent->left)
		y->parent->left = x;
	else
		y->parent->right = x;

	if (y != z)
		z->key = y->key;
	if (y->color == BLACK)
		RBDeleteFixUp(x);
}

template<class T>
void Tree<T>::RBDeleteFixUp(Node<T>* x)
{
	while (x != root && x->color == BLACK)
	{
		if (x== x->parent->left)
		{
			Node<T>* w = x->parent->right;
			if (w->color == RED)
			{
				w->color = BLACK;
				x->parent->color = RED;
				leftRotate(x->parent);
				w = x->parent->right;
			}
			else if (w->left->color == BLACK && w->right->color == BLACK)
			{
				w->color = RED;
				x = x->parent;
			}
			else if ( w->right->color == BLACK)
			{
				w->left->color = BLACK;
				w->color = RED;
				rightRotate(w);
				w = x->parent->right;
			}
			else{
				w->color = x->parent->color;
				x->parent->color = BLACK;
				w->right->color = BLACK;
				leftRotate(x->parent);
				x = root;
			}
		}
		else
		{
			Node<T>* w = x->parent->left;
			if (w->color == RED)
			{
				w->color = BLACK;
				x->parent->color = RED;
				rightRotate(x->parent);
				w = x->parent->left;
			}
			else if (w->right->color == BLACK && w->left->color == BLACK)
			{
				w->color = RED;
				x = x->parent;
			}
			else if ( w->left->color == BLACK)
			{
				w->right->color = BLACK;
				w->color = RED;
				leftRotate(w);
				w = x->parent->left;
			}
			else
			{
				w->color = x->parent->color;
				x->parent->color = BLACK;
				w->left->color = BLACK;
				rightRotate(x->parent);
				x = root;
			}
		}
	}
	x->color = BLACK;
}

template<class T>
Node<T>* Tree<T>::getSuccessor(Node<T>* node)
{
	//存在右分支
	if(node->right != NIL)
		return getMinimum(node->right);

	//若右分支不存在
	//后继结点必然是x的最低祖先节点，且后继结点的左儿子也是x的祖先
	Node<T>* p = node->parent;
	while(p != NIL && p->right == node)
	{
		node = p;
		p = p->parent;
	}
	return p;
}

//得到以node为根节点的最小值
template<class T>
Node<T>* Tree<T>::getMinimum(Node<T>* node)
{
	while(node->left != NIL)
		node = node->left;
	return node;
}


int main()
{
	Tree<int>* tree = new Tree<int>();
	Node<int>* node1 = new Node<int>();
	Node<int>* node2 = new Node<int>();
	Node<int>* node3 = new Node<int>();
	Node<int>* node4 = new Node<int>();
	Node<int>* node5 = new Node<int>();
	Node<int>* node6 = new Node<int>();
	node1->key = 4;
	node2->key = 8;
	node3->key = 1;
	node4->key = 0;
	node5->key = 12;
	node6->key = 31;

	tree->RBInsert(node1);
	tree->RBInsert(node2);
	tree->RBInsert(node3);
	tree->RBInsert(node4);
	tree->RBInsert(node5);
	tree->RBInsert(node6);

	tree->RBDelete(node1);
}