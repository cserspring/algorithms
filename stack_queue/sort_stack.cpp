/**
 * @brief Sort a stack in ascending order. You should not make any assumptions
 * about how the stack is implemented The following are the only functions 
 * that should be used to write this program: push | pop | top | empty
 */
#include <stack>
#include <iostream>

/** Use another stack, compare tmp with elements in r every time
 *  O(n^2)
 */
std::stack<int> sort(std::stack<int> s)
{
    std::stack<int> r;
    int tmp;
    while (!s.empty()) {
        tmp = s.top();
        s.pop();
        while (!r.empty() && r.top() > tmp) {
            s.push(r.top());
            r.pop();
        }
        r.push(tmp);
    }
    return r;
}

int main()
{
    std::stack<int> s;
    s.push(4);
    s.push(3);
    s.push(5);
    s.push(1);
    s.push(2);
    s = sort(s);
    while (!s.empty()) {
        std::cout << s.top() << std::endl;
        s.pop();
    }
}
