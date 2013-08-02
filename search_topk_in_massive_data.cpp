////create massive data in disk
//#include <iostream>
//#include <cstdlib>
//#include <ctime>
//using namespace std;
//
//int main(){
//    int i, j;
//    srand(time(NULL ));
//    const int maxline = 1000000;
//    freopen("a.in", "w", stdout);
//    for (i = 0; i < maxline; ++i){
//        int t = rand() % 15 + 1;
//        for (j = 0; j < t; ++j){
//            printf ("%c", rand() % 26 + 'a');
//        }
//        printf ("\n");
//    }
//    return 0;
//}


#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

const int hashm = 100;
//calculate the hash value
inline int my_hash(char *p)
{
	int t = 0;
	while (*p)
	{
		t = (*p++) + (t << 6) + (t << 16) - t;
	}
	return ((t & 0x7fffffff) % hashm);
}

//struct node_t, including a string and its occurence times
struct node_t
{
	char s[17];
	int count;
	node_t& operator =(const char *t)
	{
		strcpy(s, t);
		count = 1;
		return (*this);
	}
};

struct great_node_t
{
	char *s;
	int count;
	bool operator <(const great_node_t &a)const 
	{
		return (count > a.count);
	}
	great_node_t(const char *_s, int &_count)
	{
		s = (char *)_s;
		count = _count;
	}
};

node_t tbl[hashm][100];
int tblc[hashm];
vector<great_node_t> ans;

int main()
{
	char t[20];
	int i, j;
	int v;
	freopen("a.in", "r", stdin);
	for (i = 0; i < hashm; ++i)
	{
		tblc[i] = 0;
	}
	while (scanf ("%s", t) == 1){
		v = my_hash(t);
		for (i = 0, j = 0; i < tblc[v]; ++i)
		{
			if (strcmp(tbl[v][i].s, t) == 0)
			{
				tbl[v][i].count++;
				break ;
			}
			//if (tbl[v][i].count < tbl[v][j].count)
			//{
			//	j = i;
			//}
		}
		if (i == tblc[v])
		{
			if (i < 100)
			{
				tblc[v]++;
				tbl[v][i] = t;
			}/*else 
			//{
			//	tbl[v][j] = t;
			//}*/
		}
	}
	for (i = 0; i < hashm; ++i)
	{
		for (j = 0; j < tblc[i]; ++j)
		{
			ans.push_back(great_node_t(tbl[i][j].s, tbl[i][j].count));
		}
	}
	cout<<ans.size()<<endl;
	sort(ans.begin(), ans.end());
	for (int i = 0; i < 100 && i < (int )ans.size(); ++i)
	{
		printf ("(%d) %s\n", ans[i].count, ans[i].s);
	}
	return 0;
}