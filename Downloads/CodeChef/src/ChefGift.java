import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ChefGift {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases=Integer.parseInt(br.readLine());
        int N,X,Y;
        String input;
        boolean flag=true;
        Scanner sc=new Scanner(System.in);
        for (int i=1;i<=test_cases;i++)
        {
            N=Integer.parseInt(br.readLine());
            X=0;Y=0;
            input=sc.nextLine();
            char ch=input.charAt(0);
            if(ch=='L' || ch=='R')
                flag=false;
            for(int j=1;j<N;j++)
            {
                switch (ch){
                    case 'L': {
                        if(!flag) {
                            X--;
                            flag=true;
                        }
                    }
                        break;
                    case 'R': {
                        if(!flag) {
                            X++;
                            flag=true;
                        }
                    }
                    break;
                    case 'U': {
                        if(flag) {
                            Y++;
                            flag=false;
                        }
                    }
                    break;
                    case 'D': {
                        if(flag) {
                            Y--;
                            flag=false;
                        }
                    }
                    break;

                }
                ch=input.charAt(j);
            }
            System.out.println(X+" "+Y);
        }
    }
}
