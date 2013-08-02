#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define N 10000000
int a[N];

void create_array()
{
	srand(time(NULL));
	for (int i = 0; i < N; i++)
	{
		a[i] = rand()%N;
	}
}

int compare(const void* p1, const void* p2)
{
	if (*((int*)p1) > *((int*)p2))
		return 1;
	else if (*((int*)p1) < *((int*)p2))
		return -1;
	else
		return 0;
}

int main()
{
	create_array();

	clock_t start = clock();
	qsort(a, N, sizeof(int), compare);
	clock_t end = clock();

	printf("%f\n", (double)(end - start)/CLOCKS_PER_SEC);

	FILE* out_file = freopen("out", "w", stdout);

	for (int i = 0; i < N; i++)
	{
		printf("%d\n", a[i]);
	}
	fclose(out_file);
	return 0;
}