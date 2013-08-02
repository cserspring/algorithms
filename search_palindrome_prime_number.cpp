#include <iostream>
using namespace std;

//whether the value is odd bits and is a palindrome number, except 11
bool is_oddbits_palindrome_number(int value);
//whether value is prime
bool is_prime(int value);
int main()
{
	int a;
	int b;
	scanf("%d%d", &a, &b);
	for(int i = a; i <= b; i++)
	{
		//is_oddbits_palindrome_number is revoked first
		if(is_oddbits_palindrome_number(i) && is_prime(i))
			printf("%d\n", i);
	}
	return 0;
}

bool is_oddbits_palindrome_number(int value)
{
	char s[16];
	itoa(value, s, 10);
	int bits = strlen(s);
	//odd bits 
	if(!(bits%2) && value != 11)
		return false;
	//whether is palindrome
	for(int i = 0; i < bits/2; i++)
	{
		if(s[i] != s[bits - 1 - i])
			return false;
	}
	return true;
}

bool is_prime(int value)
{
	int middle = value/2;
	for(int i = 2; i <= middle; i++)
		if(!(value%i))
			return false;
	return true;
}