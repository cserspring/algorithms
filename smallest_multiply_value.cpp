//求两个数组的元素相乘的n个最小元素

//#include <stdio.h>
//
//int* get_multiply_value(const int *a, const int *b, const int alen, const int blen, const int n)
//{
//	int* result = new int[n];
//
//	int i = 0;//point to the first element in a[]
//	int j = 0;//point to the first element in b[]
//	int count = 0;
//	while (count < n)
//	{
//		result[count++] = a[i] * b[j];
//		
//		if (i == alen - 1 && j == blen - 1)
//		{
//			for (int p = count; p < n; p++)
//				result[p] = 0;
//			break;
//		}
//		if (i == alen - 1)
//		{
//			j++;
//			for (int p = 0; p < i; p++)
//			{
//				result[count++] = a[p] * b[j];
//			}
//		}
//		else if (j == blen - 1)
//		{
//			i++;
//			for (int p = 0; p < j; p++)
//			{
//				result[count++] = a[i] * b[p];
//			}
//		}
//		else if (a[i + 1]*b[0] < a[0]*b[j + 1])
//		{
//			i++;
//			for (int p = 0; p < j; p++)
//			{
//				result[count++] = a[i] * b[p];
//			}
//		}
//		else
//		{
//			j++;
//			for (int p = 0; p < i; p++)
//			{
//				result[count++] = a[p] * b[j];
//			}
//		}
//	}
//	return result;
//}
//int main()
//{
//	const int n = 8;
//	int a[] = {2, 4, 7, 9};
//	int b[] = {7, 8, 22, 50};
//	int *result = get_multiply_value(a, b, sizeof(a)/sizeof(a[0]), sizeof(b)/sizeof(b[0]), n);
//	for (int i = 0; i < n; i++)
//	{
//		printf("%d\n", result[i]);
//	}
//	return 0;
//}

//以下为在O(n^2)内解决这个问题
#include <iostream>
#include <stdlib.h>
using namespace std;

int cmp(const void* e1, const void* e2)
{
	return *(int*)e1 - *(int*)e2;
}

int* get_multiply_value(const int* a, const int* b, const int alen, const int blen, const int n)
{
	int* all_value = new int[alen*blen];
	int count = 0;
	for (int i = 0; i < alen; i++)
	{
		for (int j = 0; j < blen; j++)
		{
			all_value[count++] = a[i]*b[j];
		}
	}
	qsort(all_value, alen*blen, sizeof(all_value[0]), cmp);
	int* result = new int[n];
	for (int i = 0; i < n; i++)
		result[i] = all_value[i];
	delete[] all_value;

	return result;
}

int main()
{
	int a[] = {4, 2, 9, 7};
	int b[] = {22, 8, 7, 50};
	qsort(a, sizeof(a)/sizeof(a[0]), sizeof(a[0]), cmp);
	qsort(b, sizeof(b)/sizeof(b[0]), sizeof(b[0]), cmp);

	const int n = 8;
	int* result = get_multiply_value(a, b, sizeof(a)/sizeof(a[0]), sizeof(b)/sizeof(b[0]), n);

	for (int i = 0; i < n; i++)
		printf("%d\n", result[i]);
	return 0;
}