#include <iostream>
using namespace std;

void shell_sort(int* a, int n);
int main()
{
	int a[8] = {4, 7, 2, 8, 5, 1, 3, 6};
	shell_sort(a,8);
	for(int i = 0;i <8;i++)
		printf("%d\n", a[i]);
	return 0;
}

void shell_sort(int v[], int n)
{
	int gap, i, j, temp;
	for (gap = n/2; gap > 0; gap /= 2)
		for (i = gap; i < n; i++)
			for (j=i-gap; j>=0 && v[j]>v[j+gap]; j-=gap) 
			{
				temp = v[j];
				v[j] = v[j+gap];
				v[j+gap] = temp;
			}
}