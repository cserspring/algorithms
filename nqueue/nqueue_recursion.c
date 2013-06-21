#include <stdio.h>
#include <stdlib.h>

/*
 * 把棋盘存储为一个N维数组a[N]，数组中第i个元素的值代表第i行的皇后位置，
 * 这样便可以把问题的空间规模压缩维O(N)，在判断是否冲突时也很简单，首先每行只有
 * 一个皇后，且在数组中只占据一个元素的位置，行冲突就不存在了，其次是列冲突，
 * 判断一下是否有a[i]与当前要放置皇后的列j相等即可。至于斜线冲突，通过观察可以
 * 发现所有在斜线上冲突的皇后的位置都有规律即它们所在的行列互减得绝对值相等，
 * 即| row – i | = | col – a[i] | 。这样某个位置是否可以放置皇后的问题已经解决。
 */

#define N 20   //最多放皇后的个数
int q[N];         //各皇后所在的行号
int count = 0;     //统计解得个数
//输出一个解
void print(int n)
{
    int i,j;
    count++;
    printf("第%d个解：",count);
    for(i=1;i<=n;i++)
        printf("(%d,%d) ",i,q[i]);
    printf("\n");
    for(i=1;i<=n;i++)        //行
    {                
        for(j=1;j<=n;j++)    //列
        {
            if(q[i]!=j)
                printf("x ");
            else 
                printf("Q "); 
        }
        printf("\n");
    }
}

//检验第i行的k列上是否可以摆放皇后
int find(int i,int k)  
{
    int j=1;
    while(j<i)  //j=1~i-1是已经放置了皇后的行
    {
        //第j行的皇后是否在k列或(j,q[j])与(i,k)是否在斜线上
        if(q[j]==k || abs(j-i)==abs(q[j]-k)) 
            return 0;
        j++;
    }
    return 1;
}

//放置皇后到棋盘上
void place(int k,int n)  
{
    int j;
    if(k>n)
        print(n);
    else
    {
        for(j=1;j<=n;j++)   //试探第k行的每一个列
        {
            if(find(k,j))
            {
                q[k] = j;
                place(k+1,n);  //递归总是在成功完成了上次的任务的时候才做下一个任务
            }
        }
    }
}

int main(void)
{
    int n;
    printf("请输入皇后的个数(n<=20),n=:");
    scanf("%d",&n);
    if(n>20)
        printf("n值太大，不能求解!\n");
    else
    {
        printf("%d皇后问题求解如下(每列的皇后所在的行数):\n",n);
        place(1,n);        //问题从最初状态解起
        printf("\n");
    }
    return 0;
}
