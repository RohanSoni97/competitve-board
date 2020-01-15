#include<bits/stdc++.h>
#include <queue> 
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
void printLevelOrder(node* root)
{
    if(root==NULL)
    return;
    queue<node *> q;
    q.push(root);
    while(q.empty()==false)
    {
        node *newNode=q.front();
        cout<<newNode->data<<"\n";
        q.pop();
        if(newNode->left!=NULL)
        q.push(newNode->left);
        if(newNode->right!=NULL)
        q.push(newNode->right);
        
    } 
} 
int main()  
{  
    node *root = newNode(1);  
    root->left = newNode(2);  
    root->right = newNode(3);  
    root->left->left = newNode(4);  
    root->left->right = newNode(5);  
    cout << "Level Order traversal of binary tree is \n"; 
    printLevelOrder(root); 
    return 0;  
}  