#include <stdio.h>
#include <stdlib.h>

void solve(int current_sum, int basket_id, int current_num, int* basket, int N, int M)
{
	if (current_sum == N && basket_id == M)
	{
		int i;
		for (i = 0; i < M; i++)
			printf("%d\t", basket[i]);
		printf("\n");
		return;
	}

	if (current_num > N || basket_id >= M)
		return;

	if ((current_sum + current_num*(M - basket_id)) > N || 
		(current_sum + (current_sum + 1)*((1<<(M - basket_id)) - 1)) < N)
		return;

	int j;
	for (j = current_num; j <= current_sum + 1; j++)
	{
		basket[basket_id] = j;
		solve(current_sum + j, basket_id + 1, j, basket, N, M);
	}
}

int main()
{
	int N;//the number of eggs
	int M;//the number of baskets
	while (scanf("%d%d", &N, &M) != EOF)
	{
		if (N < M || N >= 1<<M || M <= 0)
			printf("Wrong data!\n");
		else
			printf("The combinations are as below:\n");

		int* basket = (int*)malloc(sizeof(int)*M);
		solve(0, 0, 1, basket, N, M);
		free(basket);
	}
	return 0;
}
