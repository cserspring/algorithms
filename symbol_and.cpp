#include <iostream>
using namespace std;

int main()
{
	int count = 0;
	int countx = 9999;

	while(countx)
	{
		count++;
		countx = countx&(countx - 1);
	}
	cout<<count<<endl;
}