import java.util.Scanner;
class Swap2Digits
{
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int T=sc.nextInt();
        if(T>=1 && T<=1000)
        {
            for(int i=0;i<T;i++)
            {
                int A=sc.nextInt();
                int B=sc.nextInt();
                if(A>0 && B >0 && A<100 && B<100)
                {
                    if(A>9 && B>9)
                    {
                        int x=A%10;
                        int w=A/10;
                        int z=B%10;
                        int y=B/10;
                        int a[]=new int[5];
                        a[0] =A+B;
                        a[1]=(((10*y)+x)+((10*w)+z));
                        a[2]=(((10*z)+x)+((10*y)+w));
                        a[3]=(((10*w)+y)+((10*x)+z));
                        a[4]=(((10*w)+z)+((10*y)+x));
                        int max=a[0];
                        for(int v=0;v<5;v++)
                        {
                            if(max<a[v])
                            {
                                max=a[v];
                            }
                        }
                        System.out.println(max);
                    }
                    if(A<10 && B<10)
                    {
                        System.out.println((A+B));
                    }
                    if((A<10 && B>9) || (A>9 && B<10))
                    {
                        if(A>B)
                        {
                            int d=A;
                            A=B;
                            B=d;
                        }
                        int x=A%10;
                        int y=B%10;
                        int z=B/10;
                        int a=A+B;
                        int b=((10*x)+y+z);
                        if(a>b)
                        {
                            System.out.println(a);
                        }
                        else
                        {
                            System.out.println(b);
                        }
                    }
                }
            }
        }
    }
}
