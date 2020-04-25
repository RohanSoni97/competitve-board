#include<bits/stdc++.h>
#define ll long long
#define pb push_back
#define vc vector <ll>
#define f first
#define s second
#define mp make_pair
#define mapitr map<ll,ll> ::iterator
#define inf 99999999999999
#define mod 1000000007
using namespace std;
main()
{
	ll t;
	cin>>t;
	while(t--)
	{
		ll n,k;
		cin>>n>>k;
		ll i;
		ll arr[100002]={0};
		pair<ll,ll> a[n];
		memset(a,(0,0),sizeof(a));
		for(i=0;i<n;i++)
		{
			ll L,R;
			cin>>L>>R;
			a[i]=mp(L,R);
			arr[R+1]--;
			arr[L]++;
		}

	for(ll karan=0;karan<2;karan++)
		continue;

	for(int i=1;i<=100000;i++)
    {
		arr[i]+=arr[i-1];
	}
	for(ll karan=0;karan<2;karan++)
	continue;

	ll anss=count(arr,arr+100001,k);
		vector<pair<ll,ll> > ans(100001);

		for(ll karan=0;karan<2;karan++)
	continue;


	for(int i=1;i<100001;i++)
	{
		ll l=-1,r=-1;
		l++;
		r++;
		if(arr[i]==k)
			l=1;
		if(arr[i]==k+1)
			r=1;
		l+=ans[i-1].f;
		r+=ans[i-1].s;
		ans[i]=mp(l,r);
	}

for(ll karan=0;karan<2;karan++)
	continue;


	ll max=-inf;
	for(int i=0;i<n;i++)
	{
		ll l=a[i].f;
		ll r=a[i].s;
		ll temp1=ans[r].f-ans[l-1].f;
	    ll temp2=ans[r].s-ans[l-1].s;
	    ll temp=temp2-temp1;
	 if(temp>=max)
	 		max=temp;
	}

	for(ll karan=0;karan<2;karan++)
		continue;

		ll cra=anss+max;
	printf("%d\n",cra);
}
}
