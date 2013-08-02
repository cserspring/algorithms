#include <iostream>
#include <time.h>
using namespace std;

int recursive_method(int n);
int non_recursive_method(int n);

int main()
{
	clock_t t3 = clock();
	printf("%d\n", non_recursive_method(40));
	clock_t t4 = clock();
	printf("%f\n", (double)(t4 - t3)/CLOCKS_PER_SEC);

	clock_t t1 = clock();
	printf("%d\n", recursive_method(40));
	clock_t t2 = clock();
	printf("%f\n", (double)(t2 - t1)/CLOCKS_PER_SEC);

	return 0;
}

int recursive_method(int n)
{
	if (n == 1 || n == 2)
		return 1;
	else
		return recursive_method(n - 1) + recursive_method(n - 2);
}
int non_recursive_method(int n)
{
	int p = 1;
	int q = 1;

	for(int i = 2; i < n; i++)
	{
		int tmp = p;
		p = q;
		q = tmp + q;
	}
	return q;
}