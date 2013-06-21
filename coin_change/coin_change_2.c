#include <stdio.h>
#include <iostream>
#define N 4
#define C 99
#define INT_MAX 1000000
using namespace std;

// In this example we take the amount as 17, and a total of 
// 4 denominations of coins

/*
 * C[p]    =     0                               if p = 0
                min(i: di < p) {1 + C[p - di]}   if p > 0
 */

int main()
{
    // contains the coin denominations
    int coins[N]={1,2,5,10};

    // C[i] contains the minimum number of coins required 
    // to form the sum i
    int amount[C+1]={0};

    for(int amt = 1; amt <= C ;amt++) {
        amount[amt] = INT_MAX;
        int temp = INT_MAX;
        for(int c = 0; c < N;c++) {
            // if the value of the coin is less than the amount
			if(coins[c] <= amt) {
                // What is the other number of coins that will be used
                // if coins[c] is used in the solution for amount i
                int temp_amt = amount[amt-coins[c]] + 1;

                // choose the minimum number of coins that will be used 
                // for the amount i
                if(temp_amt < temp) {
					temp = temp_amt;
					amount[amt] = temp;
                }
            }
        }
    }
    cout<<"The minimum number of coins to be used for amount "<<C<<" are "
		<<amount[C]<<endl;
	for (int i = 0; i < C+1; i++) {
		printf("%d\n", amount[i]);
	}
    return 0;
}
