codes
=====
#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<iostream.h>
#include<stdlib.h>
class bst
{
      public:
      struct node
      {
             struct node *left;
             struct node *right;
             int data;
             }*root,*p;
             bst()
             {
                  root=NULL;
                  }
                  void insert(int);
                  void ins(struct node *,int);
                  void inorder(struct node *);
                  void inord();
                  };
                  int main()
                  {
                  bst b;
                  int x;
                      int ch;
                      
                      while(1)
                      {
                              cin>>ch;
                      switch(ch)
                      {
                                case 1:
                                     cout<<"Enter the value to be inserted\n";
                                     cin>>x;
                                     b.insert(x);
                                     break;
                                     case 2:
                                          b.inord();
                                          break;
                                          default:
                                                  exit(0);
                                                  }
                                                  }
                                                  getch();
                                                  }
                                                  void bst::insert(int x)
                                                  {
                                                       if(root==NULL)
                                                       {
                                                                     root=new node;
                                                                     root->data=x;
                                                                     root->left=NULL;
                                                                     root->right=NULL;
                                                                     }
                                                                     else
                                                                         ins(root,x);
                                                                         }
                                                                         
                                                                         void bst::ins(struct node *r,int x)
                                                                         {
                                                                              if(x<r->data)
                                                                              {
                                                                                           if(r->left==NULL)
                                                                                           {
                                                                                            p=new node;
                                                                                            p->data=x;
                                                                                            r->left=p;
                                                                                            r->left->left=NULL;
                                                                                            r->left->right=NULL;
                                                                                            }
                                                                                            else
                                                                                           ins(r->left,x);
                                                                                           }
                                                                                           if(x>r->data)
                                                                                           {
                                                                                                        if(r->right==NULL)
                                                                                                        {
                                                                                                                          p=new node;
                                                                                            p->data=x;
                                                                                            r->right=p;
                                                                                            r->right->left=NULL;
                                                                                            r->right->right=NULL;
                                                                                            }
                                                                                            else
                                                                                                        ins(r->right,x);
                                                                                                        }
                                                                                                        }
                                                                                                        
                                                                          void bst::inorder(struct node *r)
                                                                          {
                                                                               if(r==NULL)
                                                                               return;
                                                                               else
                                                                               {
                                                                               inorder(r->left);
                                                                               cout<<r->data<<",";
                                                                               inorder(r->right);
                                                                               }
                                                                               }
                                                                               void bst::inord()
                                                                               {
                                                                                    inorder(root);
                                                                                    }
                                             