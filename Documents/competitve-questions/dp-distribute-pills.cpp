#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int main(){
    ll n,i;
    cin>>n;
    vector<ll>a(n);
    for(i=0;i<n;i++)cin>>a[i];
    ll k=0;
    ll dp[n];
    dp[0]=1;
    for(i=1;i<n;i++){
        dp[i]=1;
        if(a[i]>a[i-1])
        dp[i]=dp[i-1]+1;
    }
    for(i=n-2;i>=0;i--){
        if(a[i]>a[i+1] && dp[i]<=dp[i+1])
        dp[i]=dp[i+1]+1;
    }
    for(i=0;i<n;i++)k+=dp[i];
    cout<<k;
}