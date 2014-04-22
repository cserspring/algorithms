#include <stdio.h>

void sift(int d[], int ind, int len)
{
    int i = ind;
 
    //#c中保存i节点的左孩子#%
    int c = i * 2 + 1;
 
    while (c < len) {
        //#如果要筛选的节点既有左孩子又有右孩子并且左孩子值小于右孩子#%
        //#从二者中选出较大的并记录#%
        if (c + 1 < len && d[c] < d[c + 1])
            c++;
        //#如果要筛选的节点中的值大于左右孩子的较大者则退出#%
        if (d[i] > d[c]) {
            break;
        } else {
            //#交换#%
            int t = d[c];
            d[c] = d[i];
            d[i] = t;
            //
            //#重置要筛选的节点和要筛选的左孩子#%
            i = c;
            c = 2 * i + 1;
        }
    }
}
 
void heap_sort(int d[], int n)
{
    //#初始化建堆, i从最后一个非叶子节点开始#%
    int i = (n - 2) / 2;
    for (; i >= 0; --i)
        sift(d, i, n);
    int j = 0;
    for (; j < n; j++) {
        int t = d[0];
        d[0] = d[n - j - 1];
        d[n - j - 1] = t;
        //#筛选编号为0 #%
        sift(d, 0, n - j - 1);
 
    }
}
 
int main()
{
    int a[] = {1, 5, 3, 6, 4, 9, 5, 7, 4};
 
    heap_sort(a, sizeof(a) / sizeof(*a));
    int i = 0;
    for (; i < sizeof(a) / sizeof(*a); i++)
        printf("%d ", a[i]);
    return 0;
}
