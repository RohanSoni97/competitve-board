#include<bits/stdc++.h>
using namespace std;
class node{
    public:
    int data;
    node *left,*right;
};
node* newNode(int data)
{
    node* newNode=new node();
    newNode->data=data;
    newNode->left=NULL;
    newNode->right=NULL;
    return(newNode);
}
int main()  
{  
    node *root = newNode(1);  
    root->left = newNode(2);  
    root->right = newNode(3);  
    root->left->left = newNode(4);  
    root->left->right = newNode(5);  
    return 0;  
}  