
#include <bits/stdc++.h>

using namespace std;
#define ll long long int

int main(){
	int N,Q;
	cin >> N >> Q;
	assert(N>=1 && N<=100000);
	assert(Q>=1 && Q<=100000);
	vector<ll> A(N+1),B(N+1);
	for(int i=1;i<=N;i++)
		cin >> A[i];
	for(int i=1;i<=N;i++)
		cin >> B[i];
	for(int i=2;i<=N;i+=2){
		swap(A[i],B[i]);	
	}	
	for(int i=1;i<=N;i++){
		A[i]+=A[i-1];
		B[i]+=B[i-1];
	}
	while(Q--){
		int c,l,r;
		cin >> c >> l >> r;
		assert(l<=r);
		if(c==1){
			if(l%2){
				cout << A[r]-A[l-1] << endl;
			}else{
				cout << B[r]-B[l-1] << endl;
			}
		}else{
			if(l%2 == 0){
				cout << A[r]-A[l-1] << endl;
			}else{
				cout << B[r]-B[l-1] << endl;
			}
		}			
	}
	return 0;
}