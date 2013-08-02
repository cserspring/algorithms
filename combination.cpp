#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void get_result_in_vector(vector<vector<int> > & vec,int N,vector<int> &tmp, vector<vector<int>>& tmp_result)
{
    for(int i = 0;i<vec[N].size();++i)
    {
        tmp.push_back(vec[N][i]);
        if (N<vec.size()-1)
        {
			get_result_in_vector(vec,N+1,tmp, tmp_result);
        }
        else
		{
			vector<int> one_result;
            for (int i = 0;i<tmp.size();++i)
            {
				one_result.push_back(tmp.at(i));
            }
			tmp_result.push_back(one_result);
        }
        tmp.pop_back();
    }
}

void get_all_combination(vector<vector<int>>& vec, int result[][3])
{
    vector<int> tmp_vec;

	vector<vector<int>> tmp_result; 
	get_result_in_vector(vec,0,tmp_vec, tmp_result);

	//将vector中的数据转化为数组保存
	for (int i = 0; i < tmp_result.size(); i++)
	{
		for (int j = 0; j < tmp_result.at(i).size(); j++)
		{
			result[i][j] = tmp_result.at(i).at(j);
		}
	}
}

int main()
{
	int arr1[] = {1, 3, 4};
	int arr2[] = {2, 5};
	int arr3[] = {6, 7};
	const int first_dimension = sizeof(arr1)/sizeof(arr1[0]) * sizeof(arr2)/sizeof(arr2[0]) * sizeof(arr3)/sizeof(arr3[0]);
	//所有组合的结果
	int result[first_dimension][3];

    vector<vector<int>> vec;
    vec.push_back(vector<int>(arr1,arr1+sizeof(arr1)/sizeof(arr1[0])));
    vec.push_back(vector<int>(arr2,arr2+sizeof(arr2)/sizeof(arr2[0])));
    vec.push_back(vector<int>(arr3,arr3+sizeof(arr3)/sizeof(arr3[0])));
	get_all_combination(vec, result);

	//输出结果
	for (int i = 0; i < first_dimension; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			cout<<result[i][j]<<"\t";
		}
		cout<<endl;
	}
    return 0;
}