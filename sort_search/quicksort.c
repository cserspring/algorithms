#include <stdio.h>

#define LEN 10

int partition(int *arr, int start, int end)
{
    int pivot = arr[end];
    int i = start - 1;
    int j;
    int tmp;
    for (j = start; j < end; ++j) {
        if (arr[j] <= pivot) {
            ++i;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
    arr[end] = arr[i+1];
    arr[i+1] = pivot;
    return i+1;
}

int quicksort(int *arr, int start, int end)
{
    int pivot_location;
    if (start < end) {
        pivot_location = partition(arr, start, end);
        quicksort(arr, start, pivot_location - 1);
        quicksort(arr, pivot_location + 1, end);
    }
}

int main()
{
    int i;
    int arr[LEN] = {4, 3, 2, 7, 1, 9, 2, 5, 7, 6};
    quicksort(arr, 0, LEN - 1);
    for (i = 0; i < LEN; ++i)
        printf("%d\n", arr[i]);
    return 0;
}
