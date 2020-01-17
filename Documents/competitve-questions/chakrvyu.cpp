/*After Governor's attack on prison, Rick found himself surrounded by walkers. They are coming towards him from all sides. Now, suppose Rick have infinite number of bullets with him. Suppose Rick need 1 bullet to kill each walker (yeah he is good in killing walkers. They need to be shot at head. See, how good he is). Now as soon as he kills 1 walker rest of the walkers move forward by 1 m. There are n walkers each at some distance from Rick. If any walker is able to reach Rick, he dies. Now, you need to tell if he survives or not. If he survives print "Rick now go and save Carl and Judas" else print "Goodbye Rick" followed by no.of walkers he was able to kill before he died in next line. One more thing Rick's gun can fire 6 shots without reload. It takes him 1 sec to reload and during this time walkers move 1 m forward.

[Input]
First line contains an integer t indicating number of test cases.

Next line contains an integer n denoting no.of walkers followed by n space separated integers denoting the distance of walkers from him.

[Output]
For each test case output one line denoting the answer as explained above.

[Constraints]
1<=t<=100
1<=n<=100000
1<=dis[i]<=50000

SAMPLE INPUT 
2
5
2 4 2 5 6
4
2 2 2 2
SAMPLE OUTPUT 
Rick now go and save Carl and Judas
Goodbye Rick
2
*/

// Sample code to perform I/O:

#include <bits/stdc++.h>
using namespace std;
int ar[50005];
int main() {
	int t;
	scanf("%d",&t);
	while(t--)
	{
	    memset(ar,0,sizeof(ar));
	    int n,tmp;
	    scanf("%d",&n);
	    for(int i=1;i<=n;++i)
	    {
	        scanf("%d",&tmp);
	        ar[tmp]++;
	    }
	    int ans=0,cnt=0,j=0;
	    bool pos=true;
	    for(int i=1;i<=n;i++)
	    {
	        while(ar[j]==0)
	        j++;
	        ar[j]--;
	        if(j-cnt<=0)
	        {
	            pos=false;
	            break;
	        }
	        if(i%6==0 && i!=0)
	        {
	            cnt++;
	        }
	        cnt++;
	        ans++;
	    }
	    if(pos)
	    printf("Rick now go and save Carl and Judas\n");
	    else
			printf("Goodbye Rick\n%d\n",ans);
	}
	return 0;// Writing output to STDOUT
}

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


// Write your code here
