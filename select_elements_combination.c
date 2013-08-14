/*从数组中取出n个元素的所有组合
今天在做POJ 1753时，需要枚举一个数组中所有组合。
如数组为{1, 2, 3, 4, 5, 6}，那么从它中取出3个元素的组合有哪些，取出4个元素的组合呢？
比如取3个元素的组合，我们的思维是：
取1、2，然后再分别取3，4，5，6；
取1、3，然后再分别取4，5，6；
......
取2、3，然后再分别取4，5，5；
......
这样按顺序来，就可以保证完全没有重复。

这种顺序思维给我们的启示便是这个问题可以用递归来实现，但是仅从上述描述来看，却无法下手。
我们可以稍作改变：
1.先从数组中A取出一个元素，然后再从余下的元素B中取出一个元素，然后又在余下的元素C中取出一个元素
2.按照数组索引从小到大依次取，避免重复

依照上面的递归原则，我们可以设计如下的算法：

*/

#include <stdio.h>
#include <stdlib.h>

//arr为原始数组
//start为遍历起始位置
//result保存结果，为一维数组
//count为result数组的索引值，起辅助作用
//NUM为要选取的元素个数
void combine_decrease(int* arr, int start, int* result, int count, const int NUM)
{
  int i;
  for (i = start; i >=count; i--)
  {
    result[count - 1] = i - 1;
    if (count > 1)
    {
      combine_decrease(arr, i - 1, result, count - 1, NUM);
    }
    else
    {
      int j;
      for (j = NUM - 1; j >=0; j--)
	printf("%d\t",arr[result[j]]);
      printf("\n");
    }
  }
}

//arr为原始数组
//start为遍历起始位置
//result保存结果，为一维数组
//count为result数组的索引值，起辅助作用
//NUM为要选取的元素个数
//arr_len为原始数组的长度，为定值
void combine_increase(int* arr, int start, int* result, int count, const int NUM, const int arr_len)
{
  int i = 0;
  for (i = start; i < arr_len + 1 - count; i++)
  {
    result[count - 1] = i;
    if (count - 1 == 0)
    {
      int j;
      for (j = NUM - 1; j >= 0; j--)
        printf("%d\t",arr[result[j]]);
      printf("\n");
    }
    else
      combine_increase(arr, i + 1, result, count - 1, NUM, arr_len);
  }
}
int main()
{
  int arr[100];
  int i = 0;
  for (i = 0; i < 100; i++)
    arr[i] = i + 1;
  int num = 2;
  int result[num];

  combine_increase(arr, 0, result, num, num, sizeof(arr)/sizeof(int));
  printf("分界线\n");
  combine_decrease(arr, sizeof(arr)/sizeof(int), result, num, num);
  return 0;
}
