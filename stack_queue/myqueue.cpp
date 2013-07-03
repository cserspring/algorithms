#include <iostream>
#include <stack>

template <typename T>
class MyQueue
{
public:
	void enqueue(const T& t);
	void dequeue();
private:
	std::stack<T> stack1;
	std::stack<T> stack2;
};

template <typename T>
void MyQueue<T>::enqueue(const T& t)
{
	stack1.push(t);
}

template <typename T>
void MyQueue<T>::dequeue()
{
	if (!stack2.empty()) {
		stack2.pop();
	} else if (!stack1.empty()) {
		while (!stack1.empty()) {
			stack2.push(stack1.top());
			stack1.pop();
		}
		stack2.pop();
	} else {
		std::cout << "error: queue is empty" << std::endl;
	}
}

int main()
{
	MyQueue<int> queue;
	queue.enqueue(2);
	queue.enqueue(3);
	queue.enqueue(1);
	queue.dequeue();
	queue.enqueue(5);
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	return 0;
}
