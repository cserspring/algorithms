#include <iostream>
using namespace std;

class Node
{
public:
	int key;
	
	Node* left;
	Node* right;
	Node* parent;
	
	Node(int k);
};

class BinarySearchTree
{
public:
	Node* root;
	BinarySearchTree();
	
	//以node为根节点开始搜索
	Node* search(Node* node, int k);
	//插入节点
	void insert(Node* node);
	//删除节点
	void remove(Node* node);
	//得到最小值节点
	Node* get_minimum(Node* node);
	//得到最大值节点
	Node* get_maximum(Node* node);
	//查找前驱节点
	Node* get_predecessor(Node* node);
	//查找后继节点
	Node* get_successor(Node* node);
	//中序遍历
	void in_order_traverse(Node* node);
};

int main()
{
	int a[10] = {5, 3, 4, 2, 8, 9, 1, 7, 6, 0};
	BinarySearchTree* binary_search_tree = new BinarySearchTree();
	for(int i = 0; i < 10; i++)
		binary_search_tree->insert(new Node(a[i]));
	binary_search_tree->in_order_traverse(binary_search_tree->root);

	//get the maximum
	cout<<"get the maximum:"<<binary_search_tree->get_maximum(binary_search_tree->root)->key<<endl;

	//remove 7
	binary_search_tree->remove(binary_search_tree->search(binary_search_tree->root, 7));
	//remove 9
	binary_search_tree->remove(binary_search_tree->search(binary_search_tree->root, 9));
	//remove 5
	binary_search_tree->remove(binary_search_tree->search(binary_search_tree->root, 5));
	cout<<"after remove the nodes:"<<endl;
	binary_search_tree->in_order_traverse(binary_search_tree->root);
	return 0;
}
Node::Node(int k)
{
	key = k;
	left = right = parent = NULL;
}

BinarySearchTree::BinarySearchTree()
{
	root = NULL;
}

//插入节点
void BinarySearchTree::insert(Node* node)
{
	if(root == NULL)
	{
		root = node;
	}
	else
	{
		Node* p = root;
		Node* q = root;
		while(q != NULL)
		{
			p = q;
			if(node->key > q->key)
				q = q->right;
			else
				q = q->left;
		}

		node->parent = p;
		if(node->key > p->key)
		{
			p->right = node;
		}
		else
		{
			p->left = node;
		}
	}
}

//查找元素x
Node* BinarySearchTree::search(Node* node, int k)
{
	if(node->key == k || node == NULL)
		return node;

	if(node->key < k)
		return search(node->right, k);
	else
		return search(node->left, k);
}

//算法导论书上把这三种情况给综合起来了
//但看起来没有三种情况分别写出来清晰
//if判断的次数是相同的
void BinarySearchTree::remove(Node* node)
{
	if(node->left != NULL && node->right != NULL)
	{
		Node* temp = get_successor(node);
		int k = temp->key;
		remove(temp);
		node->key = k;
	}
	else if(node->left != NULL || node->right != NULL)
	{
		//把父节点和子节点练成一线即可
		if(node->parent->left == node)
		{
			if(node->left == NULL)
			{
				node->parent->left = node->right;
				node->right->parent = node->parent;
			}
			else
			{
				node->parent->left = node->left;
				node->left->parent = node->parent;
			}
		}
		else
		{
			if(node->left == NULL)
			{
				node->parent->right = node->right;
				node->right->parent = node->parent;
			}
			else
			{
				node->parent->right = node->left;
				node->left->parent = node->parent;
			}
		}
		delete node;
	}
	else
	{
		if(node->parent->left == node)
			node->parent->left = NULL;
		else
			node->parent->right = NULL;
		delete node;
	}
}

//得到以node为根节点的最小值
Node* BinarySearchTree::get_minimum(Node* node)
{
	while(node->left != NULL)
		node = node->left;
	return node;
}

//得到以node为根节点的最大值
Node* BinarySearchTree::get_maximum(Node* node)
{
	while(node->right != NULL)
		node = node->right;
	return node;
}

//得到key为x的前驱节点
Node* BinarySearchTree::get_predecessor(Node* node)
{
	//存在左分支
	if(node->left != NULL)
		return get_maximum(node->left);

	//若左分支不存在
	//前驱结点必然是x的最低祖先节点，且前驱结点的右儿子也是x的祖先
	Node* p = node->parent;
	while(p != NULL && p->left == node)
	{
		node = p;
		p = p->parent;
	}
	return p;
}

Node* BinarySearchTree::get_successor(Node* node)
{
	//存在右分支
	if(node->right != NULL)
		return get_minimum(node->right);

	//若右分支不存在
	//后继结点必然是x的最低祖先节点，且后继结点的左儿子也是x的祖先
	Node* p = node->parent;
	while(p != NULL && p->right == node)
	{
		node = p;
		p = p->parent;
	}
	return p;
}

//中序遍历
void BinarySearchTree::in_order_traverse(Node* node)
{
	if(node == NULL)
		return;

	in_order_traverse(node->left);
	cout<<node->key<<endl;
	in_order_traverse(node->right);

}