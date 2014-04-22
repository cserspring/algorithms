#include <stdio.h>

void sift(int d[], int ind, int len)
{
    int i = ind;
 
    //#c�б���i�ڵ������#%
    int c = i * 2 + 1;
 
    while (c < len) {
        //#���Ҫɸѡ�Ľڵ�������������Һ��Ӳ�������ֵС���Һ���#%
        //#�Ӷ�����ѡ���ϴ�Ĳ���¼#%
        if (c + 1 < len && d[c] < d[c + 1])
            c++;
        //#���Ҫɸѡ�Ľڵ��е�ֵ�������Һ��ӵĽϴ������˳�#%
        if (d[i] > d[c]) {
            break;
        } else {
            //#����#%
            int t = d[c];
            d[c] = d[i];
            d[i] = t;
            //
            //#����Ҫɸѡ�Ľڵ��Ҫɸѡ������#%
            i = c;
            c = 2 * i + 1;
        }
    }
}
 
void heap_sort(int d[], int n)
{
    //#��ʼ������, i�����һ����Ҷ�ӽڵ㿪ʼ#%
    int i = (n - 2) / 2;
    for (; i >= 0; --i)
        sift(d, i, n);
    int j = 0;
    for (; j < n; j++) {
        int t = d[0];
        d[0] = d[n - j - 1];
        d[n - j - 1] = t;
        //#ɸѡ���Ϊ0 #%
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
