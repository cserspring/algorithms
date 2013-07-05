/**
 * @brief To determine whether a node can be reached from another node in
 * a directed graph.
 */
#include <iostream>
#include <queue>
#include <cstring>

#define N 11
bool graph[N][N];
bool visited[N];
int route[N];

void init()
{
    memset(graph, 0, N*N*sizeof(bool));
    memset(visited, 0, N*sizeof(bool));
    for (int i = 0; i < N; ++i)
        route[i] = -1;
}

void DFS(int src, int dst, int& exist)
{
    visited[src] = true;
    for (int i = 0; i < N; ++i) {
        if (graph[src][i]) {
            if (i == dst) {
                exist = 1;
                break;
            }
            if (!visited[i]) {
                visited[i] = true;
                DFS(i, dst, exist);
            }
        }
    }
}

bool BFS(int src, int dst)
{
    int node;
    std::queue<int> qnode;
    qnode.push(src);
    visited[src] = true;
    while (!qnode.empty()) {
        node = qnode.back();
        qnode.pop();
        if (node == dst)
            return true;
        for (int i = 0; i < N; ++i) {
            if (graph[node][i]) {
                if (!visited[i]) {
                    visited[i] = true;
                    qnode.push(i);
                    route[i] = node;
                }
            }
        }
    }
    return false;
}

int main()
{
    int i;
    int j;
    init();
    while (std::cin >> i >> j) {
        graph[i][j] = true;
    }
    int src = 1;
    int dst = 10;
    int exist = 0;

    /* Use BFS */
    std::cout << ((exist = BFS(src, dst)) ? "Yes" : "No") << std::endl;
    if (exist) {
        std::cout << "Route as below:" << std::endl;    
        while (dst != src && dst >= 0) {
            std::cout << dst << "<-";
            dst = route[dst];
        }
        std::cout << src << std::endl;
    }

    /* Before using DFS, must comment the BFS 
    DFS(src, dst, exist);
    std::cout << exist << std::endl;
    */
    return 0;
}
