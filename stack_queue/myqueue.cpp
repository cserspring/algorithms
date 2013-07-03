/**
 * @brief Implement a queue using two stacks.
 */
#include <iostream>
#include <stack>

template <typename T>
class MyQueue
{
public:
    void enqueue(const T& t);
    void dequeue();
    T& front();
    const T& front() const;
    T& back ();
    const T& back() const;
    bool empty() const;
    size_t size() const;
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

template <typename T>
T& MyQueue<T>::front()
{
    if (!stack2.empty()) {
        return stack2.top();
    } else {
        while (!stack1.empty()) {
            stack2.push(stack1.top());
            stack1.pop();
        }
        return stack2.top();
    }
}

template <typename T>
const T& MyQueue<T>::front() const
{
    if (!stack2.empty()) {
        return stack2.top();
    } else {
        while (!stack1.empty()) {
            stack2.push(stack1.top());
            stack1.pop();
        }
        return stack2.top();
    }
}

template <typename T>
T& MyQueue<T>::back()
{
    if (!stack1.empty()) {
        return stack1.top();
    } else {
        while (!stack2.empty()) {
            stack1.push(stack2.top());
            stack2.pop();
        }
        return stack1.top();
    }
}

template <typename T>
const T& MyQueue<T>::back() const
{
    if (!stack1.empty()) {
        return stack1.top();
    } else {
        while (!stack2.empty()) {
            stack1.push(stack2.top());
            stack2.pop();
        }
        return stack1.top();
    }
}

template <typename T>
bool MyQueue<T>::empty() const
{
    if (stack1.empty() && stack2.empty())
        return true;
    return false;
}

template <typename T>
size_t MyQueue<T>::size() const
{
    return (stack1.size() + stack2.size());
}

int main()
{
    MyQueue<int> queue;
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    if (!queue.empty()) {
        std::cout << queue.front() << std::endl;
        std::cout << queue.back() << std::endl;
    }
    queue.dequeue();
    queue.enqueue(4);
    if (!queue.empty()) {
        std::cout << queue.front() << std::endl;
        std::cout << queue.back() << std::endl;
    }
    queue.enqueue(5);
    queue.dequeue();
    if (!queue.empty()) {
        std::cout << queue.front() << std::endl;
        std::cout << queue.back() << std::endl;
    }
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    if (!queue.empty()) {
        std::cout << queue.front() << std::endl;
        std::cout << queue.back() << std::endl;
    }
    queue.dequeue();
    queue.dequeue();
    return 0;
}
