#include <iostream>
using namespace std;
//求最短摘要
//题目：有一段广告，它由很多单词构成，然后它有个摘要，即关键字，问包含摘要(关键字)的在广告正文中的最短字符串是什么？
//简而言之，就是说求在原字符串中包含所有关键字的最短子序列。

//算法思想:
//将每个关键字在原字符串中位置记录在一个数组中，每个关键字对应一个数组，然后令distance = max(a[i], b[j], c[k]) - min(a[i], b[j], c[k]),
//然后最小的那个元素被它所在数组的下一个元素取代，依次循环下去。这里假设是三个关键字，然后就有三个数组。
int max(int a, int b, int c);
int min(int a, int b, int c);

int main()
{
	const int LEN = 10;
	const int MAX = 100000000;
	char** str = new char*[LEN];
	str[0] = "My";
	str[1] = "name";
	str[2] = "is";
	str[3] = "wang";
	str[4] = "name";
	str[5] = "shuai";
	str[6] = "your";
	str[7] = "name";
	str[8] = "is";
	str[9] = "wang";

	char** keyword  =new char*[3];
	keyword[0] = "wang";
	keyword[1] = "name";
	keyword[2] = "your";
	int a[LEN];
	int b[LEN];
	int c[LEN];
	for(int i = 0; i < LEN; i++)
		a[i] = b[i] = c[i] = -1;
	int j = 0;
	int k = 0;
	int l = 0;

	for(int m = 0; m < 3; m++)
	{
		for(int i = 0; i < LEN; i++)
		{
			if(strcmp(str[i], keyword[m]) == 0 && m == 0)
				a[j++] = i;
			else if(strcmp(str[i], keyword[m]) == 0 && m == 1)
				b[k++] = i;
			else if(strcmp(str[i], keyword[m]) == 0 && m == 2)
				c[l++] = i;
		}
	}
	//相隔的最短距离
	int distance;
	//三个关键字的位置
	int postion1;
	int postion2;
	int postion3;

	//用于循环的三个变量
	int p = 0;
	int q = 0;
	int r = 0;


	int minium = MAX;
	while(a[p] >= 0 && b[q] >= 0 && c[r] >= 0)
	{
		distance = max(a[p], b[q], c[r]) - min(a[p], b[q], c[r]);
		if(distance < minium)
		{
			minium = distance;
			postion1 = a[p];
			postion2 = b[q];
			postion3 = c[r];
		}
		if(min(a[p], b[q], c[r]) == a[p])
			p++;
		else if(min(a[p], b[q], c[r]) == b[q])
			q++;
		else if(min(a[p], b[q], c[r]) == c[r])
			r++;
	}

	if(minium != MAX)
	{
		cout<<"长度为："<<minium + 1<<endl;
		cout<<"从位置"<<min(postion1, postion2, postion3) + 1<<"到位置"<<max(postion1, postion2, postion3) + 1<<endl;
	}
	else
		cout<<"NO"<<endl;
	return 0;
}

int max(int a, int b, int c)
{
	int max = a > b ? a : b;
	if(c > max)
		max = c;
	return max;
}

int min(int a, int b, int c)
{
	int min = a < b ? a : b;
	if(c < min)
		min = c;
	return min;
}